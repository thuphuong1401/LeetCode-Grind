/*
https://leetcode.com/problems/subarray-sum-equals-k/
*/

/*
My solution - Time O(n^2), space O(1) => cumulative sum without space as the LeetCode solution calls it
*/
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                sum += nums[j];
                if(sum == k) {
                    count++;
                }
            }
            sum = 0;
        }
        
        return count;
    }
}


/*
Very smart solution using prefix sum
Time O(n), space O(n)
Biggie idea: sum(i, j) = sum(0, j) - sum(0, i). Therefore this problem is asking us to count how many times sum[r] - sum[l] = k.
*/
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> prefixSumFreq = new HashMap<>();
        int currPrefixSum = 0;
        prefixSumFreq.put(0, 1);
        
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            currPrefixSum += nums[i];
            int need = currPrefixSum - k;
            if(prefixSumFreq.containsKey(need)) {
                count += prefixSumFreq.get(need);
            }
            prefixSumFreq.put(currPrefixSum, prefixSumFreq.getOrDefault(currPrefixSum, 0) + 1);
        }
        return count;
        
    }
}
