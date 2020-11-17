/*
Detailed analysis here: https://medium.com/enjoy-algorithm/equilibrium-index-of-an-array-d1b06f067153
/*

/*
1. Brute force solution - Double for loops, O(n^2)
*/
class Solution {
    public int pivotIndex(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            int leftSum = 0;
            int rightSum = 0;
            for(int j = 0; j < i; j++) {
                leftSum += nums[j];
            }
            for(int j = i+1; j < nums.length; j++) {
                rightSum += nums[j];
            }
            if(leftSum == rightSum) {
                return i;
            }
            
        }
        return -1;
    }
}


/*
2. Prefix sum array
*/
class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0; 
        int leftSum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        for(int i = 0; i < nums.length; i++) {
            if(leftSum == sum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    } 
}

