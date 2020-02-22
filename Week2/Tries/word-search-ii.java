class Solution {
    Set<String> res = new HashSet<String>();
    class TrieNode {
        String word;
        char c;
        HashMap<Character, TrieNode> children = new HashMap<>();
        
        TrieNode(){   
        }
        
        TrieNode(char c){
            this.c = c;
        }
    }
    
    class Trie {
        TrieNode root;
        Trie(){
            root = new TrieNode();
        }
        
        void insert(String s){
            HashMap<Character, TrieNode> children = root.children;
            TrieNode node = null;
            for(int i=0; i<s.length(); i++){
                if(children.containsKey(s.charAt(i))){
                    node = children.get(s.charAt(i));
                } else {
                    node = new TrieNode(s.charAt(i));
                    children.put(s.charAt(i), node);
                }
                children = node.children;
            }
            node.word = s;
        }
        
        boolean startsWith(String prefix){
            HashMap<Character, TrieNode> children = root.children;
            TrieNode node = null;
            for(int i=0;i<prefix.length();i++){
                if(children.containsKey(prefix.charAt(i))){
                    node = children.get(prefix.charAt(i));
                    children = node.children;
                } else {
                    node = null;
                    return false;
                }
            }
            
            if(node != null) return true;
            return false;
        }
        
        boolean search(String prefix){
            HashMap<Character, TrieNode> children = root.children;
            TrieNode node = null;
            for(int i=0;i<prefix.length();i++){
                if(children.containsKey(prefix.charAt(i))){
                    node = children.get(prefix.charAt(i));
                    children = node.children;
                } else {
                    node = null;
                    return false;
                }
            }
            
            if(node != null && node.word != null) return true;
            return false;
        }
    }
    
    void backtrack(char[][] board, boolean[][] visited, Trie trie, String s, int x, int y){
            if(x < 0 || x >= board.length || y < 0 || y >= board[0].length) return;
            if(visited[x][y]) return;
            s += board[x][y];
            System.out.println("checking "+s);
            if(!trie.startsWith(s)) return;
            System.out.println(true);
        
            if(trie.search(s)){
                System.out.println("adding");
                res.add(s);
            }
            
            visited[x][y] = true;
            backtrack(board, visited, trie, s, x+1, y);
            backtrack(board, visited, trie, s, x-1, y);
            backtrack(board, visited, trie, s, x, y+1);
            backtrack(board, visited, trie, s, x, y-1);
            visited[x][y] = false;
        }
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(String s: words){
            trie.insert(s);
        }
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                backtrack(board, visited, trie, "", i, j);
            }
        }
        
        return new ArrayList<>(res);
    }
}
