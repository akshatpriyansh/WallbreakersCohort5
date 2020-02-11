class Solution {
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i] != 9) {
                digits[i] += 1;
                return digits;
            } else {
                int idx = i;
                while(idx >= 0 && digits[idx] == 9){
                    digits[idx--] = 0;
                }
                
                if(idx < 0){
                    int[] result = new int[digits.length + 1];
                    result[0] = 1;
                    for(int x=1;x<digits.length;x++) result[x] = digits[x-1];
                    return result;
                } else {
                    digits[idx] += 1;
                    return digits;
                }
                
            }
        }
        
        return digits;
    }
}
