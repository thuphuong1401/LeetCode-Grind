/*
https://leetcode.com/problems/sign-of-the-product-of-an-array/
*/

class Solution {
    public int arraySign(int[] nums) {
        int cnt = 0;
        for(int num : nums) {
            if(num < 0) {
                cnt++;
            }
            if(num == 0) {
                return 0;
            }
        }
        if(cnt % 2 == 0) {
            return 1;
        } else {
            return -1;
        }
    }
}
