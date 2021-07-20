/*
https://leetcode.com/problems/sort-an-array/
*/

/*
Quicksort
Side note: use inclusive range from now on while coding quicksort
*/
class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        quicksort(nums, 0, n-1); // inclusive
        return nums;
    }
    
    private void quicksort(int[] nums, int left, int right) {
        if(left < right) {
            int pivot = partition(nums, left, right);
            quicksort(nums, left, pivot - 1); // nums[pivot] has been correctly placed in its 'sorted' index. Ignore it
            quicksort(nums, pivot + 1, right);
        }
    }
    
    private int partition(int[] nums, int left, int right) { // inclusive
        int index = left - 1;
        int pivot = nums[right];
        for(int i = left; i <= right; i++) {
            if(nums[i] <= pivot) { // idea: insert numbers that are smaller than current pivot into the left hand side of the array
                index++;
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
            }
        }
        return index;
    }
}


