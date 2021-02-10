

/*
https://leetcode.com/problems/maximum-product-of-three-numbers/
*/

/*
Time O(n), Space O(1)
Big idea: max product of 3 numbers = max(firstMax*secondMax*thirdMax, firstMin*secondMin*firstMax)
*/
class Solution {
    public int maximumProduct(int[] nums) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;
        
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        
        for(int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            
            if(curr > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = curr;
            } else if(curr > secondMax) {
                thirdMax = secondMax;
                secondMax = curr;
            } else if(nums[i] > thirdMax) {
                thirdMax = curr;
            }
            
            
            if(curr < firstMin) {
                secondMin = firstMin;
                firstMin = curr;
            } else if(curr < secondMin) {
                secondMin = curr;
            }
        }
        
        return Math.max(firstMax*secondMax*thirdMax, firstMax*firstMin*secondMin);
    }
}
