/*
https://leetcode.com/problems/top-k-frequent-words/
*/

/*
Time O(N log K), Space O(N)
*/
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String s : words) {
            if(!map.containsKey(s)) {
                map.put(s, 1); 
            } else {
                map.put(s, map.get(s) + 1);
            }
        }
        List<String> answer = new ArrayList<>();
        // max heap according to freq then alphabetical order
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> compare(map, a, b));
        for(String str : map.keySet()) {
            pq.add(str);
        }
        for(int i = 0; i < k; i++) {
            answer.add(pq.remove());
        }
        return answer;
    }
    
    public int compare(Map<String, Integer> map, String a, String b) {
        // freq(a) > freq(b) => a has higher priority => return 'small' number
        if(map.get(a) > map.get(b)) {
            return -1;
        } else if(map.get(a) < map.get(b)) {
            return 1;
        } else { // a has higher priority if a < b (lexicographically)
            return a.compareTo(b);
        }
    }
}
