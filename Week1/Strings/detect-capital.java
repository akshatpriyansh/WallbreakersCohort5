class Solution {
    public boolean detectCapitalUse(String word) {
        if(Character.isLowerCase(word.charAt(0))){
            return checkAllSmall(word);
        } else {
            return checkAllCapital(word) || checkFirstCapital(word);
        }
    }
    
    public boolean checkAllCapital(String word){
        for(char c: word.toCharArray()){
            if(!Character.isUpperCase(c)) return false;
        }
        return true;
    }
    
    public boolean checkAllSmall(String word){
        for(char c: word.toCharArray()){
            if(!Character.isLowerCase(c)) return false;
        }
        return true;
    }
    
    public boolean checkFirstCapital(String word){
        for(int i=1; i<word.length();i++){
            if(!Character.isLowerCase(word.charAt(i))) return false;
        }
        
        return true;
    }
}
