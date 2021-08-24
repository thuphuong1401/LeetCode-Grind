/*
https://leetcode.com/problems/split-array-largest-sum/
*/

class Solution {
    public int splitArray(int[] nums, int m) {
        int low = 0;
        int high = (int)1e9;
        int ans = -1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(canBeSplitted(nums, mid, m)) {
                high = mid - 1;
                ans = mid;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    
    private boolean canBeSplitted(int[] nums, int mid, int m) {
        int n = nums.length;
        int numParts = 0;
        int i = 0;
        int currSum = 0;
        while(i < n) {
            if(currSum + nums[i] <= mid) {
                currSum += nums[i];
                i++;
            } else {
                currSum = 0;
                numParts++;
                if(numParts == m) {
                    return false;
                }
            }
        }
        return true;
    }
    
    
}
