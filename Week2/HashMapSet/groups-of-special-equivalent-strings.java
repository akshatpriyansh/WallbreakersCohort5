class Solution {
    public int numSpecialEquivGroups(String[] A) {
        HashSet<String> hs = new HashSet<>();
        for(String s: A){
            int[] even = new int[256];
            int[] odd = new int[256];
            for(int i=0;i<s.length();i++){
                if(i % 2 == 0) even[s.charAt(i)-'a']++;
                else odd[s.charAt(i) - 'a']++;
            }
            hs.add(Arrays.toString(even) +" "+Arrays.toString(odd));
        }
        
        return hs.size();
    }
    
    
}
