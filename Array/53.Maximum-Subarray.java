/*
https://leetcode.com/problems/maximum-subarray/
*/

/*
Brute force solution: O(n^2)
Idea: using a nested for loop, check for every possible contiguous sum. Get max
*/
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            int currSum = 0;
            for(int j = i; j < n; j++) {
                currSum += nums[j];
                maxSum = Math.max(maxSum, currSum);
            }
        }
        return maxSum;
    }
}

/*
Efficient method - Kadane's algorithm - O(n)
Idea:
- Initialize 2 variables: maxSum and currSum = first element of the array
- Loop through the array once:
    + At every element, asked yourself whether to include this element in the currSum or not => get the maximum out of 2 options: include this element in the current sum or not
    Include: currSum + nums[i]
    Not include ("restarting" the whole sum from that element: nums[i] 
    + maxSum = max of maxSum and currSum
*/
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currSum = maxSum;
        for(int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}

/*
The more subtle divide-and-conquer method
https://www.codesdope.com/blog/article/maximum-subarray-sum-using-divide-and-conquer/
*/
class Solution {
    
    public int maxSubArray(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        return maxSumSubArray(nums, low, high);
    }
    
    static int maxSumSubArray(int[] nums, int low, int high) {
        if(high == low) {
            return nums[high];
        } 
        int mid = (high + low)/2;
        
        int maxSumLeftSubarray = maxSumSubArray(nums, low, mid);
        int maxSumRightSubarray = maxSumSubArray(nums, mid+1, high);
        int maxSumCrossingSubarray = maxCrossingSubarray(nums, low, mid, high);
        
        return Math.max(Math.max(maxSumLeftSubarray, maxSumRightSubarray), maxSumCrossingSubarray);
    }
    
    static int maxCrossingSubarray(int[] nums, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = mid; i >= low; i--) {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }
        
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for(int i = mid+1; i <= high; i++) {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }
        return (leftSum + rightSum);
    }
}


