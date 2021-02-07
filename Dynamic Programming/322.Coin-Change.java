/*
https://leetcode.com/problems/coin-change/
*/


/*
Explanation:
- The recurrence relation is, dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1). 
- Have to make sure coins[j] <= i so that invalid index does not happen
- Why initial dp array was filled with amount + 1? Because theoretical max number of coins change used for amount is amount (using all 1 cent), therefore amount+1 is 
an 'impossible' amount of coins. We return -1 in such case.
*/
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        if(dp[amount] == amount+1) {
            return -1;
        } else {
            return dp[amount];
        }
    }
}
