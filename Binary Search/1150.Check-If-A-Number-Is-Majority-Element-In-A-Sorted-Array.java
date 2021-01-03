/*
https://leetcode.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array/
*/

// Binary search first => get index of first occuring target
class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int first = binarySearchFirst(nums, target);
        int last = first + nums.length/2;
        
        if(last < nums.length && nums[last] == target) {
            return true;
        }
        return false;
    }
    
    private int binarySearchFirst(int[] nums, int target) {
        int low = 0; 
        int high = nums.length;
        while(low < high) {
            int mid = low + (high - low)/2;
            if(nums[mid] < target) {
                low = mid + 1;
            } else if(nums[mid] >= target) {
                high = mid;
            }
        }
        return low;
    }
}
