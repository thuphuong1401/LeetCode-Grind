/*
https://leetcode.com/problems/number-of-longest-increasing-subsequence/
*/

/*
O(n^2) solution
*/
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] count = new int[n];
        Arrays.fill(count, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    count[i] = count[j];
                } else if (nums[i] > nums[j] && dp[j] + 1 == dp[i]) {
                    count[i] += count[j];
                }
            }
        }

        int maxLength = 0;
        int countMaxLength = 0;
        for (int i = 0; i < n; i++) {
            if (maxLength < dp[i]) {
                maxLength = dp[i];
                countMaxLength = count[i];
            } else if (maxLength == dp[i]) {
                countMaxLength += count[i];
            }
        }
        return countMaxLength;
    }
}




/*
O(nlogn) solution
*/

