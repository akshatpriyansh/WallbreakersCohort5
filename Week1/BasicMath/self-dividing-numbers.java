class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = left; i<= right ;i++){
            if(isSelfDividing(i)) al.add(i);
        }
        
        return al;
    }
    
    public boolean isSelfDividing(int num){
        if(num == 0) return false;
        int realNumber = num;
        while(num != 0){
            int lastDigit = num % 10;
            if(lastDigit == 0) return false;
            if(realNumber % lastDigit !=0 ) return false;
            num = num/10;
        }
        
        return true;
    }
}
