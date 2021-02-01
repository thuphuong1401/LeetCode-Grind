/*
https://leetcode.com/problems/power-of-two/
Power of 2 iff there's only 1 bit, all other bits = 0
*/

/*
Time O(logn), Space O(1)
*/
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 0) {
            return false;
        }
        while(n % 2 == 0) {
            n /= 2;
        }
        return (n==1);
    }
}


/*
- Set the rightmost bit to 0 
- Subtract 1 means setting the rightmost bit to 0 and all the 'lower' bits to 1. For eg, 4 = 100, 4-1 = 3, 3 = 011
=> x & (x-1) will turn of x's rightmost bit
Since power of 2 has just 1 bit, turning off the rightmost bit should set this number to 0.
*/
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 0) {
            return false;
        }
        long x = (long) n;
        return (x & (x-1)) == 0;
    }
}
