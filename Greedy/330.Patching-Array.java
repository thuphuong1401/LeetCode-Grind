/*
https://leetcode.com/problems/patching-array/
*/
class Solution {
    public int minPatches(int[] nums, int n) {
        long miss = 1L; // minimum number not covered 
        int numPatch = 0;
        int i = 0;
        while(miss <= n) {
            if(i < nums.length && nums[i] <= miss) {
                miss += nums[i]; // can add coins[i] to extend [1, miss) to [1, miss + nums[i]]
                i++;
            } else {
                numPatch++;
                miss += miss; // patch miss into nums, and add miss to extend [1, miss) to [1, miss + miss]
            }
        }
        return numPatch;
    }
}
