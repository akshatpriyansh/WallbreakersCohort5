class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0 || s == "") return true;
        HashMap<Integer, Character> hm = new HashMap<>();
        int count = 0;
        for(char c: s.toCharArray()){
            hm.put(count++, c);
        }
        System.out.println(hm);
        int hmseq = 0;
        int left = 0;
        int right = 0;
        int anscounter = 0;
        while(right < t.length()){
            char c = hm.getOrDefault(hmseq, '$');
            if(c != '$'){
                char curr = t.charAt(right);
                if(curr == c){
                    anscounter++;
                    hmseq++;
                }
                
                if(anscounter == hm.size()) return true;
                right++;
            } else {
                return false;
            }
        }
        
        return false;
    }
}
