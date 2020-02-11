class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            if(Character.isLetter(c) || Character.isDigit(c)) sb.append(c);
        }
        
        System.out.println(sb);
        for(int i=0,j=sb.length()-1;i<j;i++,j--){
            if(Character.toLowerCase(sb.charAt(i)) != Character.toLowerCase(sb.charAt(j))) return false;
        }
        
        return true;
    }
}
