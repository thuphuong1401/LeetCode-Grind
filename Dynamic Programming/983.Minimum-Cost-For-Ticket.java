/*
https://leetcode.com/problems/minimum-cost-for-tickets/
*/

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> availDays = new HashSet<>();
        int n = days.length;
        for(int day : days) {
            availDays.add(day);
        }
        
        int max = days[n - 1] + 1;
        int[] dp = new int[max];
        dp[0] = 0;
        for(int i = 1; i < max; i++) {
            if(!availDays.contains(i)) {
                dp[i] = dp[i-1];
            } else {
                dp[i] = Math.min(dp[i-1] + costs[0], 
                                 Math.min(dp[Math.max(0, i-7)] + costs[1], dp[Math.max(0, i-30)] + costs[2]));
            }
        }
        return dp[max-1];
    }
} 
