class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> ans = new ArrayList<>();
                if(s.length() < p.length() || s.length() == 0 || p.length() == 0) return ans;
        HashMap<Character, Integer> sCounts  = new HashMap<>();
        HashMap<Character, Integer> pCounts  = new HashMap<>();
        for(char c: p.toCharArray()){
            pCounts.put(c, pCounts.getOrDefault(c, 0) + 1);
        }
        
        int start = 0; int end = 0;
        
        while(end < s.length()){
            char c = s.charAt(end);
            int c_val = sCounts.getOrDefault(c, 0);
            sCounts.put(c, c_val + 1);
            
            if(pCounts.equals(sCounts)) ans.add(start);
            
            System.out.println(pCounts +" "+ sCounts);
            if(end - start + 1 == p.length()){
                char leftchar = s.charAt(start);
                System.out.println(leftchar);
                start++;
                sCounts.put(leftchar, sCounts.get(leftchar) - 1);
                if(sCounts.get(leftchar) == 0 ) sCounts.remove(leftchar);
            }
            end++;
        }
        
        return ans;
    }
}
