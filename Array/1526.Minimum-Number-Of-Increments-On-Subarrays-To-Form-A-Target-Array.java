/*
https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/
Very smart problem. Learn the 'wall of bricks' approach.
*/
class Solution {
    public int minNumberOperations(int[] target) {
        int n = target.length;
        int res = target[0];
        for(int i = 1; i < n; i++) {
            res += Math.max((target[i] - target[i-1]), 0);
        }
        return res;
    }
}
