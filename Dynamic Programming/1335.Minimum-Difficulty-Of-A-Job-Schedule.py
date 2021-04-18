/*
https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/
*/

class Solution:
    
    def minDifficulty(self, jobDifficulty: List[int], d: int) -> int:
        
        n = len(jobDifficulty)
        if n < d:
            return -1
        
        jobDifficulty = [-1] + jobDifficulty 
        dp = [[10 ** 9] * (d + 1) for _ in range(n + 1)]
        
        for i in range(1, n + 1):
            for j in range(1, d + 1):
                if j > i:
                    pass
                if j == 1:
                    dp[i][j] = max(jobDifficulty[: i + 1])
                else:
                    for k in range(1, i):
                        dp[i][j] = min(dp[i][j], dp[k][j-1] + max(jobDifficulty[k + 1 : i + 1]))
                        
        return dp[n][d]
    
