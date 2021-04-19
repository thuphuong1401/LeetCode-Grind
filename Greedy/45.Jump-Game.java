/*
https://leetcode.com/problems/jump-game-ii/
*/
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int currMax = 0;
        int currLevel = 0;
        for(int i = 0; i < n-1; i++) {
            currMax = Math.max(currMax, i + nums[i]);
            if(i == currLevel) {
                ans++;
                currLevel = currMax;
            }
        }
        return ans;
    }
}
