/*
https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
*/

class Solution {
    public int maxProduct(int[] nums) {
        Integer max = null;
        Integer secondMax = null;
        for(int num : nums) {
            if(max == null || num > max) { // important: have to change 2nd max when 1st max is changed
                secondMax = max;
                max = num;
            } else if(secondMax == null || num > secondMax) {
                secondMax = num;
            }
        }
        return (max - 1) * (secondMax - 1);
    }
}
