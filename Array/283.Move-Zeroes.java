/*
https://leetcode.com/problems/move-zeroes/
*/

// Time O(n^2), Space O(1), based on idea of bubble sort
class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n-1; j++) {
                if(nums[j] == 0) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }
}


// Very smart solution indeed
// Idea: keep a pointer called the positionOfLastNonZero pointer. Loop through the nums array. If encounter nums[i] != 0, copy it to the positionOfLastNonZero
// Fill the rest from last non zero with zeroes
class Solution {
    public void moveZeroes(int[] nums) {
        int positionOfLastNonZero = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[positionOfLastNonZero++] = nums[i];
            }
        }
        
        for(int i = positionOfLastNonZero; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
