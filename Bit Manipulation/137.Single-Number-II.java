/*
https://leetcode.com/problems/single-number-ii/
*/

class Solution {
    // dem so bit 1 theo tung cot. 
    public int singleNumber(int[] nums) {
        int[] cnt = new int[32]; // dem so bit 1 o moi cot ith
        for(int num : nums) {
            for(int i = 0; i < 32; i++) {
                if(((num >> i) & 1) == 1) {
                    cnt[i]++;
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < 32; i++) {
            if(cnt[i] % 3 == 1) {
                ans |= (1 << i);
            }
        }
        return ans;
    }
}
