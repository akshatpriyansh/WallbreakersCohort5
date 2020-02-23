class Solution {
    public boolean lemonadeChange(int[] bills) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(5, 0);
        hm.put(10, 0);
        hm.put(20, 0);

        for(int i: bills){
            if(i == 5) hm.put(5, hm.get(5) + 1);
            if(i == 10) {
                int bill = hm.get(5);
                if(bill > 0) {
                    hm.put(5, hm.get(5) - 1);
                    hm.put(10, hm.get(10) + 1);
                }
                else return false;
            }
            if(i == 20){
                int bill5 = hm.get(5);
                int bill10 = hm.get(10);
                
                if(bill5 > 0 && bill10 > 0){
                    hm.put(5, hm.get(5) - 1);
                    hm.put(10, hm.get(10) - 1);
                    hm.put(20, hm.get(20) + 1);
                } else if(bill10 == 0 && bill5 > 0){
                    if(bill5 >= 3) {
                        hm.put(5, hm.get(5) - 3);
                        hm.put(20, hm.get(20) + 1);
                    } else {
                        return false;
                    }
                } else return false;
            }
        }
        return true;
    }
}
