class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        if(words.length == 0) return 0;
        String[] code = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        HashSet<String> hs = new HashSet<>();
        for(String s: words){
            String formed = "";
            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);
                String newCode = code[c-'a'];
                formed += newCode;
            }
            hs.add(formed);
        }
        
        return hs.size();
    }
}
