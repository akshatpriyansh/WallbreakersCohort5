class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            int number = nums[i];
            for(int j=i+1;j<nums.length;j++){
                if(number + nums[j] == target) return new int[]{i,j};
            }
        }
        
        return new int[]{-1,-1};
    }
}