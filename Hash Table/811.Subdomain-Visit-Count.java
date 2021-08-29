/*
https://leetcode.com/problems/subdomain-visit-count/
*/

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        
        List<String> ans = new ArrayList<>();
        Map<String, Integer> domainFreq = new HashMap<>();
        
        for(String cpdomain : cpdomains) {
            String[] tokens = cpdomain.split("\\s+");
            int freq = Integer.parseInt(tokens[0]);
            String[] subDomains = tokens[1].split("\\.");
            
            int n = subDomains.length;
            StringBuilder sb = new StringBuilder();
            for(int i = n-1; i >= 0; i--) {
                if(i != n-1) {
                    sb.insert(0, ".");
                }
                sb.insert(0, subDomains[i]);
                String s = sb.toString();
                if(!domainFreq.containsKey(s)) {
                    domainFreq.put(s, freq);
                } else {
                    domainFreq.put(s, domainFreq.get(s) + freq);
                }
            }
        }
        
        for(String domain : domainFreq.keySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(domainFreq.get(domain));
            sb.append(" ");
            sb.append(domain);
            ans.add(sb.toString());
        }
        
        return ans;
        
    }
}
