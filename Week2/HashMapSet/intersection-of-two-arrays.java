class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hs = new HashSet<>();
        for(int num : nums2){
            hs.add(num);
        }
        
        HashSet<Integer> ans = new HashSet<>();
        for(int num : nums1){
            if(hs.contains(num)) ans.add(num);
        }
        
        int[] arr = new int[ans.size()];
        int i = 0;
        for(int num: ans){
            arr[i++] = num;
        }
        return arr;
    }
}
