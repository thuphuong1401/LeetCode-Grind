/*
https://leetcode.com/problems/sort-characters-by-frequency/
*/

// Using hash map + max heap => Time O(n log n), Space O(n). It runs faster than the 2nd solution although the time complexity is technically greater.
class Solution {
    public String frequencySort(String s) {
        StringBuilder answer = new StringBuilder();
        Map<Character, Integer> freq = new HashMap<>();
        for(char c : s.toCharArray()) {
            if(!freq.containsKey(c)) {
                freq.put(c, 1);
            } else {
                freq.put(c, freq.get(c) + 1);
            }
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((c1, c2) -> compare(freq, c1, c2));
        for(char c : freq.keySet()) {
            pq.add(c);
        }
        while(!pq.isEmpty()) {
            char c = pq.remove();
            for(int i = 0; i < freq.get(c); i++) {
                answer.append(c);
            }
        }
        return answer.toString();
    }
    
    
    public int compare(Map<Character, Integer> freq, char c1, char c2) {
        if(freq.get(c1) > freq.get(c2)) {
            return -1;
        } else {
            return 1;
        }
    }
}


// Using bucket sort - Time O(n), Space O(n)
class Solution {
    public String frequencySort(String s) {
        if(s == null || s.isEmpty()) {
            return s;
        }
        
        Map<Character, Integer> freq = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for(char c : s.toCharArray()) {
            if(!freq.containsKey(c)) {
                freq.put(c, 1);
            } else {
                freq.put(c, freq.get(c) + 1);
            }
            max = Math.max(max, freq.get(c));
        }
        
        // bucket sort
        List<List<Character>> buckets = new ArrayList<>();
        for(int i = 0; i <= max; i++) {
            buckets.add(new ArrayList<Character>());
        }
        for(Character key : freq.keySet()) {
            int count = freq.get(key);
            buckets.get(count).add(key);
        }
        
        // Build string from buckets
        StringBuilder answer = new StringBuilder();
        for(int i = buckets.size() - 1; i >= 1; i--) {
            for(Character c : buckets.get(i)) {
                for(int j = 0; j < i; j++) {
                    answer.append(c);
                }
            }
        }
        return answer.toString();
    }
}
