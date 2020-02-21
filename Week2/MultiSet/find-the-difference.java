class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> hs = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int val = hs.getOrDefault(c, 0);
            hs.put(c, val+1);
        }
        
        for(int i=0;i<t.length();i++){
            char c = t.charAt(i);
            int val = hs.getOrDefault(c, 0);
            if(val == 0) return c;
            hs.put(c, val-1);
        }
        
        return '2';
    }
    
}
