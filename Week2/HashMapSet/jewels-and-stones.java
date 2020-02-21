class Solution {
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> hs = new HashSet<>();
        for(char c: J.toCharArray()) hs.add(c);
        
        int count = 0;
        for(char c: S.toCharArray()){
            if(hs.contains(c)) count++;
        }
        
        return count;
    }
}
