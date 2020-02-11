class Solution {
    public int findComplement(int num) {
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            int n = (num%2);
            if(n == 1) sb.append("0");
            else sb.append("1");
            num >>= 1;
        }
        return Integer.parseInt(sb.reverse().toString(), 2);
    }
}
