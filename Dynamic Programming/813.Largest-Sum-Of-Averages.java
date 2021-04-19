/*
https://leetcode.com/problems/largest-sum-of-averages/
*/
class Solution {
    
    public double largestSumOfAverages(int[] A, int K) {
        int n = A.length;
        double[][] dp = new double[n+1][K+1];
        double total = 0.0;
        
        for(int i = 1; i <= n; i++) {
            total += A[i-1];
            dp[i][1] = (total)/i;
        }
        
        for(int i = 1; i <= n; i++) {
            for(int j = 2; j <= K; j++) {  // notice j = 2 not j = 1
                if(j > i) {
                    continue;
                }
                for(int k = 1; k < i; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[k][j-1] + getAverage(A, k, i-1));    
                }
            }
        }
        
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= K; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        
        double ans = 0;
        for(int i = 0; i <= K; i++) {
            ans = Math.max(ans, dp[n][i]);
        }
        return ans;
    }
    
    
    private double getAverage(int[] A, int start, int end) {
        double total = 0;
        for(int i = start; i <= end; i++) {
            total += (double)A[i];
        }
        return total /= (end - start + 1);
    }
    
}
