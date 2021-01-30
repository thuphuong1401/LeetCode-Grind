/*
https://leetcode.com/problems/missing-number/
Big idea:
- XOR all numbers from 1..n
- XOR all numbers in the array
- XOR the 2 results is the missing number => Why? Because the missing number is the one that doesn't have 'pair', therefore it doesn't cancel out to 0
*/

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xor = calculateXOR(n);
        int xorArray = 0;
        for(int i : nums) {
            xorArray ^= i;
        }
        return xor ^ xorArray;
    }
    
    
    // Old CP trick
    public int calculateXOR(int n) {
        int xor = 0;
        if(n % 4 == 0) {
            return n;
        } else if(n % 4 == 1) {
            return 1;
        } else if(n % 4 == 2) {
            return n+1;
        } else {
            return 0;
        }
    }
    
    
}
