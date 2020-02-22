class Solution {
    class TrieNode {
        char c;
        int index;
        HashMap<Character, TrieNode> children = new HashMap<>();
        
        TrieNode(char c){
            this.c = c;
        }
    }
    
    class Trie {
        String[] words;
        TrieNode root;
        
        Trie(){
            root = new TrieNode('0');
        }
        
        void insert(String s, int index){
            TrieNode curr = root;
            for(char c: s.toCharArray()){
                curr.children.putIfAbsent(c, new TrieNode(c));
                curr = curr.children.get(c);
            }
            curr.index = index;
        }
        
        public String dfs(){
            String ans = "";
            Stack<TrieNode> st = new Stack<>();
            st.push(root);
            while(!st.isEmpty()){
                TrieNode curr = st.pop();
                if(curr.index > 0 || curr == root){
                    if(curr != root){
                        String word = words[curr.index - 1];
                        if(word.length() > ans.length() ||
                          word.length() == ans.length() && word.compareTo(ans) < 0){
                            ans = word;
                        }
                    }
                   
                    for(TrieNode n: curr.children.values()){
                        st.push(n);
                    }
                }
            }
            return ans;
        }
    }
    
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        int index = 0;
        for(String word: words){
            trie.insert(word, ++index);
        }
        
        trie.words = words;
        return trie.dfs();
    }
}
