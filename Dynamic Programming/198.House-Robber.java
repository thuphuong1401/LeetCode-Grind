/*
https://leetcode.com/problems/house-robber/
Big idea: at every house i, the robber has 2 choice:
- Rob the house => reward = reward[house 0 to house i-2] + house[i]
- Not rob the house => reward = reward[house 0 to house i-1].
The robber wants to choose whatever option that yields the maximum value.
Hence the recurrence relation is dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i])
*/


/*
My implementation - Time O(N), Space O(N). A bit lengthy nevertheless.
*/
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        } else if(n == 1) {
            return nums[0];
        } else if(n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = Math.max(nums[0] + nums[2], nums[1]);
        for(int i = 3; i < n; i++) {
            dp[i] = Math.max(Math.max(dp[i-1], dp[i-3] + nums[i]), dp[i-2] + nums[i]);
        }
        return dp[n-1];
    }
}


/*
A more concise one. Same idea tho. Space can be reduced to O(1) using 2 pointers
*/
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        } else if(n == 1) {
            return nums[0];
        }
        
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[n-1];
        
    }
}
