/*
https://leetcode.com/problems/house-robber-ii/
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
        
        int ans1 = robRange(nums, 0, n-2);
        int ans2 = robRange(nums, 1, n-1);
        return Math.max(ans1, ans2);
    }
    
    /*
    Learn this 2-pointer space optimization trick. It's very smart imo.
    */
    public int robRange(int[] nums, int start, int end) {
        int t1 = 0;
        int t2 = 0;
        
        for(int i = start; i <= end; i++) {
            int temp = t1;
            int curr = nums[i];
            t1 = Math.max(curr + t2, t1);
            t2 = temp;
        }
        
        return t1;
    }
}
