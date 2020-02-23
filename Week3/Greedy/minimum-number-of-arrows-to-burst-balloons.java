class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0 || points[0].length == 0) return 0;
        Arrays.sort(points, new Comparator<int[]>(){
            public int compare(int[] A, int[] B){
                return A[0] - B[0];
            }
        });
        int[] arr = points[0];
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for(int i=1; i< points.length;i++){
            int[] interval = points[i];
            if(interval[0] >= arr[0] && interval[0] <= arr[1]){
                if(interval[1] < arr[1]) arr[1] = interval[1];
                continue;
            } else {
                ArrayList<Integer> ans = new ArrayList<>();
                ans.add(arr[0]);
                ans.add(arr[1]);
                al.add(ans);
                arr[0] = interval[0];
                arr[1] = interval[1];
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(arr[0]);
        ans.add(arr[1]);
        al.add(ans);

        System.out.println(ans);
        return al.size();
    }
}
