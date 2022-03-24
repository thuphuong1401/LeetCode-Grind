/*
https://leetcode.com/problems/subarrays-with-k-different-integers/

The idea is very elegant
1. Number of subarrays with k distinct elements = number of subarrays with AT MOST k distinct element - number of subarrays with AT MOST (k - 1) distinct elements
2. Number of subarrays with at most k distinct elements: note that for each sliding window of at most k distinct elements, there are k distinct subarrays
contributing to the final answer.
*/

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return numSubarraysWithAtMostKDistinct(nums, k) - numSubarraysWithAtMostKDistinct(nums, k - 1);
    }
    
    private int numSubarraysWithAtMostKDistinct(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int result = 0;
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        while(j < n) {
            int curr = nums[j];
            if(!freq.containsKey(curr)) {
                freq.put(curr, 1);
            } else {
                freq.put(curr, freq.get(curr) + 1);
            }
            
            while(freq.size() > k) {
                freq.put(nums[i], freq.get(nums[i]) - 1);
                if(freq.get(nums[i]) == 0) {
                    freq.remove(nums[i]);
                }
                i++;
            }
            
            result += (j - i + 1);
            j++;
        }
        
        return result;
    }
    
}
