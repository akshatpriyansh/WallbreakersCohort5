class Solution {
    public int[] findErrorNums(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        int duplicated = 0;
        for(int num: nums){
            if(!hs.add(num)){
                duplicated = num;   
            }
        }
        System.out.println(hs);
        int ans = 0;
        
        for(int i=1;i<Integer.MAX_VALUE;i++){
            if(!hs.contains(i)) {
                ans = i;
                break;
            }
        }
        
        return new int[]{duplicated, ans};
    }
    
}
