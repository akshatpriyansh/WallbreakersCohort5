class Trie {
    TrieNode root;
    class TrieNode{
        char c;
        HashMap<Character, TrieNode> children;
        boolean isEnd;
        
        TrieNode(){
            children = new HashMap<>();    
        }
        
        TrieNode(char c){
            this.c = c;
            children = new HashMap<>();
        }
        
        void setEnd(){
            this.isEnd = true;
        }
    }
    
    /** Initialize your data structure here. */
    public Trie() {
            root = new TrieNode();
    }
    
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        HashMap<Character, TrieNode> children = root.children;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            TrieNode node;
            if(children.containsKey(c)){
                node = children.get(c);
            } else {
                node = new TrieNode(c);
                children.put(c, node);
            }
            
            children = node.children;
            
            if(i == word.length() - 1) {
                node.setEnd();
            }
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = null;
        HashMap<Character, TrieNode> children = root.children;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(children.containsKey(c)){
                node = children.get(c);
                children = node.children;
            } else {
                return false;
            }
        }
        
        if(node != null && node.isEnd) return true;
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        HashMap<Character, TrieNode> children = root.children;
        TrieNode node = null;
        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            if(children.containsKey(c)){
                node = children.get(c);
                children = node.children;
            } else {
                return false;
            }
        }
        
        if(node != null) return true;
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
