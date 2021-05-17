/*
https://leetcode.com/problems/minimum-operations-to-make-the-array-increasing/
*/

class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int minOps = 0;
        for(int i = 1; i < n; i++) {
            if(nums[i] > nums[i-1]) {
                continue;
            } else {
                int minDiff = nums[i-1] + 1 - nums[i]; 
                minOps += minDiff;
                nums[i] += minDiff;
            }
        }
        return minOps;
    }
}
