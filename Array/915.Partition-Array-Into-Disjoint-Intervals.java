/*
https://leetcode.com/problems/partition-array-into-disjoint-intervals/
*/
class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] minFromRight = new int[n];
        int leftLength = -1;
        minFromRight[n-1] = nums[n-1];
        for(int i = n-2; i >= 0; i--) {
            minFromRight[i] = Math.min(minFromRight[i+1], nums[i]);
        }
        int maxFromLeft = nums[0];
        for(int i = 0; i < n-1; i++) {
            if(maxFromLeft <= minFromRight[i+1]) {
                leftLength = i + 1;
                break;
            }
            maxFromLeft = Math.max(maxFromLeft, nums[i]);
        }
        return leftLength;
        
    }
}
