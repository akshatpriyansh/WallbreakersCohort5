class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int idx = 0;
        int total = 0;
        
        for(int i=0;i<g.length && idx < s.length;){
            if(g[i] <= s[idx]){
                total++;
                i++; idx++;
            } else {
                idx++;
            }
        }
        
        return total;
    }
}
