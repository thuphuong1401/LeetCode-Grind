/*
https://leetcode.com/problems/kth-largest-element-in-an-array/
*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int low = 0;
        int n = nums.length;
        int high = n - 1;
        int pivotIndex = -1;
        while(low < high) {
            pivotIndex = partition(nums, low, high);
            if(pivotIndex == n - k) {
                return nums[pivotIndex];
            } else if(pivotIndex < n - k) {
                low = pivotIndex + 1;
            } else {
                high = pivotIndex - 1;
            }
        }
        return nums[low];
    }
    
    
    private int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int j = low;
        for(int i = low; i <= high; i++) {
            if(nums[i] < pivot) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
        int temp2 = nums[high];
        nums[high] = nums[j];
        nums[j] = temp2;
        
        return j;
    }
    
}
