class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> counts = new HashMap<>();
        
        for(String s: cpdomains){
            String[] arr = s.split(" ");
            String domain = arr[1];
            int val = Integer.parseInt(arr[0]);
            if(counts.containsKey(domain)){
                int value = counts.get(domain);
                counts.put(domain, val + value);
            } else {
                counts.put(domain, val);
            }
            
            int left = domain.indexOf(".")+1;
            int right = left + 1;
            while(right != domain.length()){
                if(domain.charAt(right) == '.'){
                    String str = domain.substring(left, domain.length());
                    if(counts.containsKey(str)){
                        int v = counts.get(str);
                        counts.put(str, val + v);
                    } else {
                        counts.put(str, val);
                    }
                    left = right + 1;
                } 
                right++;
            }
            // add parent domain now
            String snn = domain.substring(domain.lastIndexOf(".")+1, domain.length());
            if(counts.containsKey(snn)){
                int v = counts.get(snn);
                counts.put(snn, val + v);
            } else {
                counts.put(snn, val);
            }
        }
        
        ArrayList<String> result = new ArrayList<>();
        for(Map.Entry<String, Integer> e: counts.entrySet()){
            result.add(e.getValue()+" "+e.getKey());
        }
        
        return result;
    }
}
