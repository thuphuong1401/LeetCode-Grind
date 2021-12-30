/*
https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/
*/

class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> prefixSumMap = new HashMap<>(); // (prefixSum, ending position)
        int longest = 0;
        int prefixSum = 0;
        prefixSumMap.put(0, -1);
        for(int i = 0; i < n; i++) {
            int curr = nums[i];
            prefixSum += curr;
            if(prefixSumMap.containsKey(prefixSum - k)) {
                int currLength = i - prefixSumMap.get(prefixSum - k);
                longest = Math.max(longest, currLength);
            }
            if(!prefixSumMap.containsKey(prefixSum)) {
                prefixSumMap.put(prefixSum, i);
            }
        }
        return longest;
        
    }
}
