/*
https://leetcode.com/problems/number-of-1-bits/

Both solutions have time complexity of O(logn) and space complexity O(1)
*/


/*
My solution
*/
public class Solution {
    
    public int hammingWeight(int n) {
        
        int count = 0;
        int s = 32;
        while(n != 0 && s > 0) {
            if((n & 1) == 1) {
                count++;
            }
            n >>= 1;
            s--;
        }
        return count;
    }
}


/*
LeetCode's solution. The only difference is the right shift operator. I used >>, got TLE without the s > 0 condition in the while loop.
This solution uses >>>.
Comparison: 
>> : arithmetic shift (preserved signess, therefore first bit won't change). This is why the 1st solution without the s > 0 check will get 
TLE since the first bit never changes. If it's one, it's an eternal loop.
>>> : logical shift (just shift, don't care about signess)
*/
public class Solution {
    
    public int hammingWeight(int n) {
        
        int count = 0;
        while(n != 0) {
            if((n & 1) == 1) {
                count++;
            }
            n >>>= 1;
        }
        return count;
    }
}


