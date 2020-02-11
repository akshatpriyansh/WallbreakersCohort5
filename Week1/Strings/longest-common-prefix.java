class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        
        Arrays.sort(strs);
        char[] largest = strs[0].toCharArray();
        
        for(int i=1;i<strs.length;i++){
            char[] string = strs[i].toCharArray();
            int itr = 0;
            for(int j=0;j<string.length && itr<largest.length;j++){
                if(string[j] != largest[itr]){
                    while(itr < largest.length){
                        largest[itr++] = '$';
                    }
                } else {
                    itr++;
                }
            }
        }
        
        String newString = "";
        for(int i=0;i<largest.length;i++){
            if(largest[i] != '$') newString += largest[i];
        }
        
        return newString;
    }
}
