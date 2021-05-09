/*
This is a very nice and very smart Codeforces-style greedy problem.
https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/
Big idea:
- Final position to move all chips to is either even or odd
- Chips at even positions can reach all other even positions with total cost = 0. Similarly, chips at odd positions can reach all other odd positions with total cost = 0
- So let's imagine moving all even-positioned chips to 0 and odd-positioned chips to 1 (or literally any other even & odd positions that are next to each other). 
- Then we can move one pile on top of another. 
=> min cost = min(evenCount, oddCount).
*/

class Solution {
    public int minCostToMoveChips(int[] position) {
        int n = position.length;
        int evenCount = 0;
        int oddCount = 0;
        for(int i = 0; i < n; i++) {
            if(position[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        return Math.min(evenCount, oddCount);
         
    }
}
