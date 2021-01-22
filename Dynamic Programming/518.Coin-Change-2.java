/*
https://leetcode.com/problems/coin-change-2/
*/

class Solution {
    public int change(int amount, int[] coins) {
        int[] res = new int[amount + 1];
        res[0] = 1;
        for(int i = 0; i < coins.length; i++) {
            for(int j = coins[i]; j <= amount; j++) { 
                // curr # of ways to make change = curr NOT used coins[i] + curr used coins[i]
                res[j] = res[j] + res[j - coins[i]];
            }
        }
        return res[amount];
    }
}
