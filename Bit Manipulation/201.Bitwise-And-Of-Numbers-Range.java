/*
https://leetcode.com/problems/bitwise-and-of-numbers-range/
Big idea: find the common prefix of left and right (in binary)
*/
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int shiftLeft = 0;
        while(left != right) {
            left >>= 1;
            right >>= 1;
            shiftLeft++;
        }
        return left << shiftLeft;
    }
} 
