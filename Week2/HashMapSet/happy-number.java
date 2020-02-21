class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> hs = new HashSet<>();
        while(n != 1){
            int num = 0;
            while(n != 0){
                int a = n % 10;
                num += Math.pow(a, 2);
                n = n/10;
            }
            System.out.println(num);
            if(hs.contains(num)) return false;
            hs.add(num);
            n = num;
        }
        return true;
    }
}
