/*
https://leetcode.com/problems/subarray-sum-equals-k/
*/

/*
Brute force method - O(n^2)
*/
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int currSum = 0;
            for (int j = i; j < nums.length; j++) {
                currSum += nums[j];
                if (currSum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}

/*
 * Efficient method - Hash Table - O(n^2) Very smart. See solution for a
 * detailed analysis Big idea: suppose we have a prefix sum array of nums called
 * sum. sum[i] - sum[j] = k means the continuous sum of elements between i and j
 * is k
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        // a map that stores (sum[i], frequency of sum[i] so far)
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            // cumulative sum up to the ith index
            sum += nums[i];
            // this means sum[i] - sum[j] = k has already happened in an interval (i, j)
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
