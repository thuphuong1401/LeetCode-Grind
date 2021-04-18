'''
https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/
'''

''' 
  dp[i][j]: min diff chia j doan tu 0 toi i (n * d)
  - dp[i - 1][j]
  - dp[i][j - 1]: min diff chia j - 1 doan tu dau toi i
  - dp[i - 1][j - 1]: 
  +
  dp[i][j] vs dp[i-1][j-1]?
  
  
  dp[i][j] = min(dp[i][j], dp[i-1][j-1] + max?)
}

dp[i][j]: min diff chia j doan tu dau toi phan tu thu i 

[6, 1, 2, 3, 4, 5]  d = 
dp[0][1] = 6
dp[1][1] = 6
dp[1][2] = dp[1][1] + max(...)
dp[2][1] = max(arr[2], arr[1])
dp[2][2] = min(dp[2][2], 
dp[0][1] + max(arr[1:]),
dp[1][1] + max(arr[2:])
)
dp[3][1] = max(arr[3], arr[2], arr[1])
dp[3][2] = min(dp[3][2],
dp[0][2] + max(arr[1:]),
dp[1][2] + max(arr[2:]),
dp[2][2] + max(arr[3:]),
)

'''
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
    
