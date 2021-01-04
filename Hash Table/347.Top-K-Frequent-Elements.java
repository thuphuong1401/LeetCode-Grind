/*
https://leetcode.com/problems/top-k-frequent-elements/
*/


// Approach 1: Heap, Time O(N log N)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] answer = new int[k];
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i : nums) {
            if(!freq.containsKey(i)) {
                freq.put(i, 1);
            } else {
                freq.put(i, freq.get(i) + 1);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> compare(freq, a, b));
        for(Integer integer : freq.keySet()) {
            pq.add(integer);
        }
        for(int i = 0; i < k; i++) {
            answer[i] = pq.remove();
        }
        return answer;
    }
    
    public int compare(Map<Integer, Integer> freq, int a, int b) {
        if(freq.get(a) > freq.get(b)) {
            return -1;
        } else {
            return 1;
        } 
    }   
}


// Approach 2: QuickSelect algorithm


