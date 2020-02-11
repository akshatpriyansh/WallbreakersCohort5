class Solution {
    // 110
    //10110
    public int binaryGap(int N) {
        int num = N & (N-1);
        if(num == 0) return 0;
        int max = 0 ;
        int localMax = 0;
        boolean toggled = false;
        while(N != 0){
            int lastDigit = N%2;
            if(lastDigit == 1){
                toggled = true;
                localMax = 1;
            
            } else {
                if(toggled) {
                    localMax++;
                    max = Math.max(max, localMax);
                } else {
                    toggled = false;
                    localMax = 0;
                }
            }
            N >>= 1;
        }
        
        return Math.max(max,1 );
    }
}
