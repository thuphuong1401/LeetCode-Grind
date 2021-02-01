/*
https://leetcode.com/problems/reverse-bits/
*/

public class Solution {
    
    public int reverseBits(int n) {
        int s = 32;
        int rev = 0;
        while(n != 0 && s > 0) {
            rev <<= 1;
            if((n & 1) == 1) {
                rev ^= 1; // keep other bits intact
            }
            s--;
            n >>= 1;
        }
        
        if(s > 0) {
            rev <<= s;
        }
        return rev;
    }
}
