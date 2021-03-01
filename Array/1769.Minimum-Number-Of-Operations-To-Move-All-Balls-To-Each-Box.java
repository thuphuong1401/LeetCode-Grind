/*
https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
Idea: arr[i] = leftSum[i] + rightSum[i]
  - leftSum[i] = leftSum[i-1] + number of 1s before i to the left
  - rightSum[i] = rightSum[i+1] + number of 1s before i to the right
Understand:
  - Need leftSum[i-1] moves to move all balls before i to i-1. Total of moves to move all balls in i-1 to i is number of 1s before i to the left
  - Ditto
*/
class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        
        int[] left = new int[n];
        int[] right = new int[n];
        int[] ans = new int[n];
        
        int numOnesLeft = boxes.charAt(0) - '0';
        for(int i = 1; i < n; i++) {
            left[i] = left[i-1] + numOnesLeft;
            if(boxes.charAt(i) == '1') {
                numOnesLeft++;
            }
        }
        
        int numOnesRight = boxes.charAt(n-1) - '0';
        for(int i = n-2; i >= 0; i--) {
            right[i] = right[i+1] + numOnesRight;
            if(boxes.charAt(i) == '1') {
                numOnesRight++;
            }
        }
        
        for(int i = 0; i < n; i++) {
            ans[i] = left[i] + right[i];
        }
        
        return ans;
    }
}

