/*
https://leetcode.com/problems/russian-doll-envelopes/
*/


/*
O(N^2) solution
1. Sort the array in increasing order of width
2. Perform O(N^2) method of Longest Increasing Subsequence
*/
class Solution {
    
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        
        Arrays.sort(envelopes, (env1, env2) -> Integer.compare(env1[0], env2[0]));
        
        for(int i = 1; i < n; i++) {
            int[] currEnv = envelopes[i];
            for(int j = 0; j < i; j++) {
                int[] env = envelopes[j];
                if(currEnv[0] > env[0] && currEnv[1] > env[1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
}


