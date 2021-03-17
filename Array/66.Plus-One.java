/*
https://leetcode.com/problems/plus-one/
*/

class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int i = n;
        int sum = 0, carry = 0;
        while(i-- > 0) {
            if(i == n-1) {
                sum = digits[i] + 1;
            } else {
                sum = digits[i] + carry;
            }
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        if(carry != 0) {
            digits = new int[n+1];
            digits[0] = carry;
        }
        return digits;
    }
}
