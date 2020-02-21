class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Integer> hm1 = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();
        
        int counts1 = 0, counts2 = 0;
        String s1 = "";
        for(char c: s.toCharArray()){
            int val = hm1.getOrDefault(c, counts1);
            if(val == counts1) { hm1.put(c, val); counts1++; }
            s1 += val;
        }
        System.out.println(s1);
        String s2 = "";
        for(char c: t.toCharArray()){
            int val = hm2.getOrDefault(c, counts2);
            if(val == counts2) { hm2.put(c, val); counts2++; }
            s2 += val;
        }
        System.out.println(s2);
        
        return s1.equals(s2);
    }
}
