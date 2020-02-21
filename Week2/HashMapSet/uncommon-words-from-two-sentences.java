class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        HashMap<String, Integer> hm = new HashMap<>();
        for(String word: A.split(" ")){
            hm.put(word, hm.getOrDefault(word,0)+1);
        }
        for(String word: B.split(" ")){
            hm.put(word, hm.getOrDefault(word,0)+1);
        }
        
        List<String> ans = new LinkedList();
        for(String word: hm.keySet()){
            if(hm.get(word) == 1) ans.add(word);
        }
        
        return ans.toArray(new String[ans.size()]);
    }
}
