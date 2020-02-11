class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int[][] flippedImage = flip(A);
        return invert(flippedImage);
    }
    
    public int[][] flip(int[][] A){
        for(int i=0;i<A.length;i++){
            for(int x=0,y=A[0].length-1;x<y;x++,y--){
                int temp = A[i][x];
                A[i][x] = A[i][y];
                A[i][y] = temp;
            }
        }
        
        return A;
    }
    
    public int[][] invert(int[][] A){
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                if(A[i][j] == 0) A[i][j] = 1;
                else A[i][j] = 0;
            }
        }
        
        return A;
    }
}
