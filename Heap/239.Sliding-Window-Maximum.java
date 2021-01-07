/*
https://leetcode.com/problems/sliding-window-maximum/
*/


// The correct brute force way, Time limit exceeded, pass 52/60 test cases
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 1) {
            return nums;
        }
        
        int n = nums.length;
        int[] answer = new int[n-k+1];
        for(int i = 0; i < n-k+1; i++) {
            answer[i] = getMaxValue(nums, i, k);
        }    
        return answer;
    }
    
    public int getMaxValue(int[] nums, int index, int k) {
        int max = nums[index];
        for(int i = index; i < index + k; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }   
}


