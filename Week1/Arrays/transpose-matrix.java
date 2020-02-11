class Solution {
    public int[][] transpose(int[][] A) {
        int[][] result;
        if(A.length == A[0].length) {
            result = new int[A.length][A[0].length];
        } else {
            result = new int[A[0].length][A.length];
        }
        
        
        int x = 0;
        int y = 0;
        
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                int num = A[i][j];
                result[x][y] = num;
                x++;
            }
            x = 0;
            y += 1;
        }
        
        return result;
    }
}
