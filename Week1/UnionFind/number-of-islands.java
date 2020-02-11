class Solution {
    class UnionFind{
        int[] parents;
        UnionFind(int size){
            parents = new int[size];
            Arrays.fill(parents, -1);
        }
        
        public void union(int a, int b){
            int rootA = find(a);
            int rootB = find(b);
            if(rootA != rootB){
                parents[rootB] = rootA;
            }
        }
        
        public int find(int node){
            if (parents[node] == node) {  
                return node;
            }
            parents[node] = find(parents[node]);  
            return parents[node];
        }
    }
    int cols;
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int rows = grid.length;
        cols = grid[0].length;
        int size = rows*cols;
        UnionFind uf = new UnionFind(size);
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == '1'){
                    uf.parents[i*cols+j]=i*cols+j;
                    if(i-1 >=0 && grid[i-1][j] == '1') uf.union(getIndex(i,j), getIndex(i-1, j));
                    if(j-1 >=0 && grid[i][j-1] == '1') uf.union(getIndex(i,j), getIndex(i, j-1));
                }
            }
        }
        
        int[] parents = uf.parents;
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<parents.length;i++){
            if(parents[i] != -1) hs.add(uf.find(i));
        }        
        return hs.size();
    }
    
    public int getIndex(int i, int j){
        return i*cols+j;
    }
}
