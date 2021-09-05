/*
https://leetcode.com/problems/reorganize-string/
*/

class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for(char c : s.toCharArray()) {
            if(!count.containsKey(c)) {
                count.put(c, 1);
            } else {
                count.put(c, count.get(c) + 1);
            }
        }
        
        int n = s.length();
        PriorityQueue<Character> pq = new PriorityQueue<>((c1, c2) -> compare(c1, c2, count));
        for(char c : count.keySet()) {
            pq.add(c);
        }
        char[] ans = new char[n];
        int i = 0;
        
        while(!pq.isEmpty()) {
            char top = pq.remove().charValue();
            
            if(i == 0) {
                ans[i] = top;
                count.put(top, count.get(top) - 1);
                if(count.get(top) > 0) {
                    pq.add(top);
                }
            } else {
                char prev = ans[i-1];
                if(prev == top) {
                    if(pq.size() == 0) {
                        return "";
                    }
                    char curr = pq.remove();
                    ans[i] = curr;
                    count.put(curr, count.get(curr) - 1);
                    if(count.get(curr) > 0) {
                        pq.add(curr);
                    }
                    pq.add(top);
                } else {
                    ans[i] = top;
                    count.put(top, count.get(top) - 1);
                    if(count.get(top) > 0) {
                        pq.add(top);
                    }
                }    
            }   
            
            i++;
        }
        
        return String.valueOf(ans);
        
    }
    
    
    private int compare(char c1, char c2, Map<Character, Integer> count) {
        int count1 = count.get(c1);
        int count2 = count.get(c2);
        
        if(count1 > count2) {
            return -1;
        } else if(count1 < count2) {
            return 1;
        } else {
            return (c1 - c2);
        }
        
    }
    
}

