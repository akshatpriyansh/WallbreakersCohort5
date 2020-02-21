class Solution {
    public int firstUniqChar(String s) {
        HashSet<Character> hs = new HashSet<>();
        HashSet<Character> hs2 = new HashSet<>();
        for(char c: s.toCharArray()){
            if(hs.contains(c)){
                hs.remove(c);
                hs2.add(c);
            } else if(hs2.contains(c)){
                continue;    
            } else {
                hs.add(c);
            }
        }
        
        for(char c: s.toCharArray()){
            if(hs.contains(c)) return s.indexOf(c);
        }
        
        return -1;
    }
}
