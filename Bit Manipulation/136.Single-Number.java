/*
https://leetcode.com/problems/single-number/
General idea that I have to remember: XOR

a ^ a = 0
a ^ 0 = a
XOR is commutative

Idea: If number appear twice => number has a pair, will cancel out if we XOR all numbers in nums 
*/


class Solution {
    public int singleNumber(int[] nums) {
        int xorAllNums = 0;
        for(int i : nums) {
            xorAllNums ^= i;
        }
        return xorAllNums;
    }
}
