class Solution {
    public boolean wordPattern(String pattern, String str) {
        HashMap<String, Integer> hm1 = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();
        
        int counts1 = 0, counts2 = 0;
        String s1 = "";
        String[] array = str.split(" ");
        for(String s: array){
            int val = hm1.getOrDefault(s, counts1);
            if(val == counts1) { hm1.put(s, val); counts1++; }
            s1 += val;
        }
        
        System.out.println(s1);
        String s2 = "";
        for(char c: pattern.toCharArray()){
            int val = hm2.getOrDefault(c, counts2);
            if(val == counts2) { hm2.put(c, val); counts2++; }
            s2 += val;
        }
        System.out.println(s2);
        
        return s1.equals(s2);
    }
}
