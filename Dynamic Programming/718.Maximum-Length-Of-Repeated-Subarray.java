/*
https://leetcode.com/problems/maximum-length-of-repeated-subarray/
*/

/*
My solution - based on LCS, but 2nd condition where A[i] != B[j] is different
*/
class Solution {
    public int findLength(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        
        int[][] dp = new int[n+1][m+1];
        int maxLength = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(A[i-1] == B[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = 0; // set to 0 instead of max(dp[i-1][j], dp[i][j-1]) because subarray is contiguous.
                }
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }
        return maxLength;
    }
}

