/*
https://leetcode.com/problems/hamming-distance/
*/

class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0;
        while(x != 0 || y != 0) {
            int lastDigitX = 0;
            int lastDigitY = 0;
            if((x & 1) == 1) {
                lastDigitX = 1;
            } else {
                lastDigitX = 0;
            }
            
            if((y & 1) == 1) {
                lastDigitY = 1;
            } else {
                lastDigitY = 0;
            }
            
            if(lastDigitX != lastDigitY) {
                count++;
            }
            
            x = x >> 1;
            y = y >> 1;
        }
        return count;
    }
}
