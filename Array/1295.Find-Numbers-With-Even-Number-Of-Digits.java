/*
https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
*/
class Solution {
    public int findNumbers(int[] nums) {
        int countEven = 0;
        for(int number : nums) {
            int numDigit = 0;
            while(number != 0) {
                number /= 10;
                numDigit++;
            }
            if(numDigit % 2 == 0) {
                countEven++;
            }
        }
        return countEven;
    }
}
