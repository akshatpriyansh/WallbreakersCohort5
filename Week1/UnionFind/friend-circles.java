class Solution {
    class UnionFind{
        int[] parents;
        UnionFind(int size){
            parents = new int[size];
            for(int i=0;i<size;i++){
                parents[i] = i;
            }
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
    public int findCircleNum(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int rows = grid.length;
        cols = grid[0].length;
        UnionFind uf = new UnionFind(rows);
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == 1){
                    if(i != j) uf.union(i, j);
                } 
            }
        }
        
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<uf.parents.length;i++){
            hs.add(uf.find(i));
        }
        
        return hs.size();
    }
    
    public int getIndex(int i, int j){
        return i*cols+j;
    }
}
