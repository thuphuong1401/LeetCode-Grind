/*
https://leetcode.com/problems/product-of-array-except-self/
*/

/*
First solution - Time O(n), Space O(n)
Big idea: 
- Calculate 2 array called leftProduct and rightProduct
  + leftProduct[i] = prefix product from the left of i, excluding i
  + rightProduct[i] = prefix product from the right of i, excluding i
- Multiply leftProduct and rightProduct element-wise, we got the solution
Why? Product of array except self (i) means product of 1. all elements to the left of i (leftProduct[i]) and 2. all elements to the right of i (rightProduct[i])
*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftProduct = new int[n];
        int[] rightProduct = new int[n];
        int[] output = new int[n];
        
        leftProduct[0] = 1;
        for(int i = 1; i < n; i++) {
            leftProduct[i] = leftProduct[i-1] * nums[i-1];
        }
        
        rightProduct[n-1] = 1;
        for(int i = n-2; i >= 0; i--) {
            rightProduct[i] = rightProduct[i+1] * nums[i+1];
        }
        
        
        for(int i = 0; i < n; i++) {
            output[i] = leftProduct[i] * rightProduct[i];
        }
        
        return output;
    }
}


/*
Second solution - same idea, O(1) space due to optimization of leftProduct and rightProduct array
NOTE: be absolutely aware of the array indexing tho
*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int n = nums.length;
        int[] output = new int[n];
        
        output[0] = 1;
        for(int i = 1; i < n; i++) {
            output[i] = output[i-1] * nums[i-1];
        }
        
        
        int rightProduct = 1;
        for(int i = n-2; i >= 0; i--) {
            rightProduct *= nums[i+1];
            output[i] = output[i] * rightProduct;
        }
        return output;
    }
}
