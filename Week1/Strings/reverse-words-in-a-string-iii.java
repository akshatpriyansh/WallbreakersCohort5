import java.util.StringJoiner;

class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        int index = 0;
        for(String str: words){
            words[index++] = new StringBuilder(str).reverse().toString();
        }
        return String.join(" ",words);
    }
}
