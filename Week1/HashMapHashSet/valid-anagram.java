class Solution {
    public boolean isAnagram(String s, String t) {
        int[] counts = new int[256];
        for(char c: s.toCharArray()){
            counts[c]++;
        }
        for(char c: t.toCharArray()){
            counts[c]--;
        }
        
        for(int i: counts){
            if(i != 0) return false;
        }
        return true;
    }
}
