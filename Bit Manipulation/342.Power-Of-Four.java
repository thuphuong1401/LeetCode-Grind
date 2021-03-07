/*
https://leetcode.com/problems/power-of-four/

Bit positions are all 0-indexing, intepreted from right to left.

Big idea:
1. Check whether a number > 0
2. Check whether a number is a power of 2
3. Check whether the power of 2 is EVEN. Power of 2 odd => the only 1 bit is at odd position, Power of 2 even => the only 1 bit is at even position
0xaaaaaaa mask: all even bits are 1, all odd bits are 0. 
*/

class Solution {
    public boolean isPowerOfFour(int n) {
        return (n > 0) && isEvenPowerOfTwo(n);
    }
    
    private boolean isPowerOfTwo(int n) {
        return ((n & (n-1)) == 0);
    }
    
    private boolean isEvenPowerOfTwo(int n) {
        boolean x = isPowerOfTwo(n);
        if(!x) {
            return false;
        }
        return ((n & 0xaaaaaaaa) == 0); // is the only 1 bit at even position?
    }
}
