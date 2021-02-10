/*
https://leetcode.com/problems/maximum-product-subarray/
*/

/*
Brute force method: try all the subarrays.
Time O(n^2), Space O(1)
*/
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProduct = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            int currProduct = 1;
            for(int j = i; j < n; j++) {
                currProduct *= nums[j];
                maxProduct = Math.max(maxProduct, currProduct);
            }
        }
        return maxProduct;
    }
}


/*
Intuition: using something quite similar to the Kadane's algorithm, which builds local maximums, then loop through those local maximums to arrive
at a global maximum.
Best choice at arr[i] is the max among:
1. arr[i]
2. minSoFar (may be very small negative number) * arr[i]
3. maxSoFar * arr[i]
Time O(n), Space O(1)

NOTE: have to have temp variable to avoid modifying maxSoFar before updating minSoFar (because minSoFar's update requires maxSoFar)
*/
class Solution {
    public int maxProduct(int[] nums) {
        
        int n = nums.length;
        if(n == 0) {
            return 0;
        }
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int max = maxSoFar;
        for(int i = 1; i < n; i++) {
            int temp = Math.max(nums[i], Math.max(maxSoFar * nums[i], minSoFar * nums[i]));
            
            minSoFar = Math.min(nums[i], Math.min(maxSoFar * nums[i], minSoFar * nums[i]));
            
            maxSoFar = temp;
            max = Math.max(max, maxSoFar);
        }
        return max;
    }
}



