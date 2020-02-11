class Solution {
    class UnionFind{
    int[] parents;
    int[] rank;
    UnionFind(int size){
        parents = new int[size];
        rank = new int[size];
        for(int i=0;i<size;i++) {
            parents[i] = i;
        }
    }
    
    public void union(int i,int j){
           int rooti = find(i);
            int rootj = find(j);
            
            if(rooti == rootj) return;
            
            if(rank[rootj] < rank[rooti]){
                parents[rootj] = rooti;
            }else{
                parents[rooti] = rootj;
                if(rank[rooti] == rank[rootj]) rank[rootj]++;
            }
    }
    
    public int find(int n){
            while(n != parents[n]){
                parents[n] = parents[parents[n]];
                n = parents[n];
            }
        return n;
    }
}
    
    public int aa = 0;
    public void solve(char[][] board) {
        if(board.length == 0 || board[0].length == 0) return;
        int rows = board.length;
        int cols = board[0].length;
        if(rows == 1 && cols == 1) return;
        if(rows == 2 && cols == 2) return;
        
        aa = cols;
        int dummyNode = rows*cols;
        UnionFind uf = new UnionFind(dummyNode + 1);
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j] == 'O'){
                    if(i == 0 || i == rows-1 || j == 0 || j == cols - 1){
                        uf.union(getIndex(i,j), dummyNode);
                    }else{
                        if(j - 1 >= 0 && board[i][j - 1] == 'O')  uf.union(getIndex(i, j), getIndex(i, j - 1));
                        if(i - 1 >= 0 && board[i - 1][j] == 'O')  uf.union(getIndex(i, j), getIndex(i - 1, j));
                        if(i + 1 < rows && board[i + 1][j] == 'O')   uf.union(getIndex(i, j), getIndex(i + 1, j));
                        if(j + 1 < cols && board[i][j + 1] == 'O')   uf.union(getIndex(i, j), getIndex(i, j + 1));

                } 
                }
            }
        }
        
        for(int i = 0;i < rows;i++){
            for(int j = 0;j < cols;j++){
                if(board[i][j] == 'O'){
                    if(uf.find(getIndex(i, j)) == uf.find(dummyNode)) board[i][j] = 'O';
                    else    board[i][j] = 'X';
                }
            }
        }
    }
    
    public int getIndex(int row, int col){
        return row*aa + col;
    }
}
