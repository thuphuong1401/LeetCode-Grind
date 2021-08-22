/*
https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
*/

class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        return helper(nums, target, 0, n-1);
    }
    
    
    private boolean helper(int[] nums, int target, int left, int right) {
        
        while(left <= right) {
            int mid = left + (right - left)/2;

            if(nums[mid] == target) {
                return true;
            }

            if(nums[mid] < nums[left]) { // reflection point is in [left, mid]. CANNOT have <= here. '=' happens when array has 2 elements left to search. 
                if(target >= nums[left] || target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if(nums[mid] > nums[left]) { // reflection point is in [mid, right] OR there's no reflection point at all
                if(target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if(nums[mid] < nums[right]) {
                    if(target > nums[mid]) {
                        left = mid + 1;
                    } else {
                        return false;
                    }
                } else if(nums[mid] > nums[right]) {
                    if(target >= nums[mid] || target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        return false;
                    }
                } else {
                    boolean onLeft = helper(nums, target, left, mid-1);
                    boolean onRight = helper(nums, target, mid+1, right);
                    return onLeft || onRight;
                }
            }
        }
        
        return false;
    }
 
    
}
