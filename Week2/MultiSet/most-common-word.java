class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> bannedWords = new HashSet<>();
        for(String s: banned) bannedWords.add(s);
        
        HashMap<String, Integer> hm = new HashMap<>();
        int max = 0;
        String maxWord = "";
        String[] words = paragraph.split(",\\s*|\\.\\s*|!\\s*|\\?\\s*|'\\s*|;\\s*|\\s+");
        for(String word: words){
            String lword = word.toLowerCase();
            if(bannedWords.contains(lword)) continue;
            
            int val = hm.getOrDefault(lword, 0);
            int newVal = val + 1;
            hm.put(lword, newVal);
            if(newVal > max){
                max = newVal;
                maxWord = lword;
            }
        }
        
        return maxWord;
    }
}
