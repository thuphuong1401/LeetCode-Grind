/*
https://leetcode.com/problems/longest-increasing-subsequence/
*/

/*
Approach 1: O(n^2)
Big idea:
dp[i]: length of LIS ending at pos i
For every nums[i], check whether this nums[i] can be used to extend any previous increasing subsequence nums[1...i-1] (if nums[i] > nums[j] && dp[i] < dp[j] + 1)
*/
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int max = -1;
        int[] dp = new int[n]; // dp[i]: length of LIS ending at i
        Arrays.fill(dp, 1);
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
}
