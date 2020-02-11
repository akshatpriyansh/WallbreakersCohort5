class Solution {
    public String reverseVowels(String s) {
        ArrayList<Character> vowels = new ArrayList<>();
        for(char c : s.toCharArray()){
            if(isVowel(Character.toLowerCase(c))) vowels.add(c);
        }
        
        int currIndexOfVowel = vowels.size() - 1;
        char[] sArray = s.toCharArray();
        for(int i=0; i<sArray.length;i++){
            if(isVowel(Character.toLowerCase(sArray[i]))){
                sArray[i] = vowels.get(currIndexOfVowel--);
            }
        }
        
        return new String(sArray);
    }
    
    public boolean isVowel(char c){
        if(c == 'a' || c == 'e' || c== 'i' || c=='o' || c=='u') return true;
        return false;
    }
}
