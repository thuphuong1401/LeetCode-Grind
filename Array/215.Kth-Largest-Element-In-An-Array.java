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


/*
Another version with random index
*/
import java.lang.*;

class Solution {
    
    Random rand = new Random();
    
    public int findKthLargest(int[] nums, int k) {
        int targetIndex = nums.length - k;
        return quickSelect(nums, targetIndex, 0, nums.length - 1);
    }
    
    private int quickSelect(int[] nums, int targetIndex, int left, int right) {
        if(left <= right) {
            int pivotIndex = partition(nums, left, right);
            if(pivotIndex == targetIndex) {
                return nums[pivotIndex];
            } else if(pivotIndex > targetIndex) {
                return quickSelect(nums, targetIndex, left, pivotIndex - 1);
            } else {
                return quickSelect(nums, targetIndex, pivotIndex + 1, right);
            }
        }
        return -1;
    }
    
    private int partition(int[] nums, int left, int right) {
        int index = left - 1;
        int l = right - left + 1;
        
        int randIndex = left + rand.nextInt(l);
        
        int pivot = nums[randIndex];
        int temp = nums[right];
        nums[right] = nums[randIndex];
        nums[randIndex] = temp;
        
        for(int i = left; i <= right; i++) {
            if(nums[i] <= pivot) {
                index++;
                temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
            }
        }
        
        return index;
    }
    
}
