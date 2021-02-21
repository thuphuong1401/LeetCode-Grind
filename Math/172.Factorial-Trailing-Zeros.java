/*
https://leetcode.com/problems/factorial-trailing-zeroes/
*/

class Solution {
    public int trailingZeroes(int n) {
        int zeroCount = 0;
        long currentMultiple = 5;
        while(n > 0) {
            n /= 5;
            zeroCount += n;
        }
        return zeroCount;
    }
}
