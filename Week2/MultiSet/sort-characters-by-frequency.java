class Solution {
    public String frequencySort(String s) {
        if(s.length() == 0 ) return s;
        if(s.length() < 3) return s;
        int[] arr = new int[256];
        int max = 0;
        for(char c: s.toCharArray()){
            arr[c]++;
            max = Math.max(arr[c], max);
        }
        
        HashMap<Integer, ArrayList<Character>> hm = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 0) continue;
            
            if(!hm.containsKey(arr[i])){
                hm.put(arr[i], new ArrayList<Character>());
            } 
            
            hm.get(arr[i]).add((char)i);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=max; i > 0; i--){
            if(hm.containsKey(i)){
                ArrayList<Character> ans = hm.get(i);
                for(int j=0;j<ans.size();j++){
                    for(int k=0;k<i;k++){
                        sb.append(ans.get(j));
                    }
                }
            }
        }
        
        return sb.toString();
        
    }
}
