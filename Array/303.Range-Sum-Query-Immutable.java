/*
https://leetcode.com/problems/range-sum-query-immutable/
*/
class NumArray {
    int[] prefixSum;
    
    public NumArray(int[] nums) {
        int n = nums.length;
        prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for(int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }        
    }
    
    public int sumRange(int i, int j) {
        if(i == 0) {
            return prefixSum[j];
        }
        return prefixSum[j] - prefixSum[i-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
