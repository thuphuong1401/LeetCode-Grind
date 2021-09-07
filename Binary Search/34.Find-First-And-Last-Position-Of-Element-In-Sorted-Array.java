/*
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstOccurrence = bsFirst(nums, target);
        int lastOccurrence = bsLast(nums, target);
        
        return new int[]{firstOccurrence, lastOccurrence};
    }
    
    private int bsFirst(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            int midVal = nums[mid];
            if((mid == 0 && midVal == target) || (midVal == target && nums[mid - 1] != midVal)) {
                return mid;
            } else if(midVal < target) {
                low = mid + 1;
            } else if(midVal >= target) { // "=" very important. Want to push the right bound to as far right as possible
                high = mid - 1;
            }
        }
        return -1;
    }
    
    
    private int bsLast(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            int midVal = nums[mid];
            if((mid == n-1 && midVal == target) || (midVal == target && nums[mid + 1] != midVal)) {
                return mid;
            } else if(midVal <= target) { // same thing, "=" is very important here
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    
}
