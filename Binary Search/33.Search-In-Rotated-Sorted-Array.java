/*
https://leetcode.com/problems/search-in-rotated-sorted-array/
*/

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(nums[mid] == target) {
                return mid;
            }
            
            if(nums[mid] < nums[left]) { // reflection point is in [left, mid]. CANNOT have <= here. '=' happens when array has 2 elements left to search. 
                if(target >= nums[left] || target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // reflection point is in [mid, right] OR there's no reflection point at all
                if(target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}


