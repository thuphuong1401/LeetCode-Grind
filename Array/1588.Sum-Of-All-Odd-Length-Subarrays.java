/*
https://leetcode.com/problems/sum-of-all-odd-length-subarrays/

Note:
- total number of subarrays containing arr[i] = startingHere * endingHere
- if total is odd, number of odd length subarrays is total/2 + 1.

=> Take example to see the rules
0 1 2 3 4 
i = 0 => ending here = 1, starting here = 5, total = 5, numOdd = 3 

0 1 2 3
i = 0 => ending here = 1, starting here = 4, total = 4, numOdd = 2
*/

class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int sumOddLengthArrays = 0;
        for(int i = 0; i < n; i++) {
            int endingHere = i + 1; // number of subarrays ending at i
            int startingHere = n - i; // number of subarrays starting at i
            int totalSubArrays = endingHere * startingHere;
            int numOdds = totalSubArrays / 2;
            if(totalSubArrays % 2 == 1) {
                numOdds++;
            }
            sumOddLengthArrays += (arr[i] * numOdds);
        }
        return sumOddLengthArrays;
    }
}
