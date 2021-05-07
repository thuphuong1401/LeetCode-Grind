/*
https://leetcode.com/problems/longest-continuous-increasing-subsequence/
*/

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return 1;
        }
        int maxLength = 1;
        int currLength = 1;
        for(int i = 1; i < n; i++) {
            if(nums[i-1] < nums[i]) {
                currLength++;
            } else {
                currLength = 1;
            }
            maxLength = Math.max(maxLength, currLength);
        }
        return maxLength;
    }
}
