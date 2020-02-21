class Solution {
    public int distributeCandies(int[] candies) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int type = 0;
        int forSister = candies.length/2;
        for(int candy: candies){
            int val = hm.getOrDefault(candy, 0);
            hm.put(candy, val+1);
        }
        
        for(Map.Entry<Integer, Integer> e : hm.entrySet()){
            if(forSister == 0) return type;
            else type++;
            
            forSister--;
        }
        
        return type;
    }
}
