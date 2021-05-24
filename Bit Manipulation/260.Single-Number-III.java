/*
https://leetcode.com/problems/single-number-iii/
*/

class Solution {
    // Key idea: dựa vào vị trí của 1 bit để  chia nhóm
    // Chia thành 2 nhóm, mỗi nhóm có tổng XOR là 1 answer
    /*
    Những bài có XOR:
    - Đếm bit mỗi cột
    
    */
    public int[] singleNumber(int[] nums) {
        int xorSum = 0;
        for(int num : nums) {
            xorSum ^= num;
        }
        int col = 0;
        for(int i = 0; i < 31; i++) {
            if((xorSum & (1 << i)) != 0) { // ith bit of xorSum == 1
                col = i;
                break;
            }
        }
        int groupOne = 0; // xor sum of all nums whose ith bit is 1
        int groupTwo = 0; // xor sum of all nums whose ith bit is 0
        for(int num : nums) {
            if((num & (1 << col)) != 0) {
                groupOne ^= num;
            } else {
                groupTwo ^= num;
            }
        }
        
        return new int[]{groupOne, groupTwo};
    }
}
