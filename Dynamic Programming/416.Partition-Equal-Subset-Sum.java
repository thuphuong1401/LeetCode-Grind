/*
https://leetcode.com/problems/partition-equal-subset-sum/
*/

/*
2D DP method
*/
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int total = 0;
        for(int num : nums) {
            total += num;
        }
        if(total % 2 == 1) {
            return false;
        }
        int half = total/2;
        boolean[][] dp = new boolean[n+1][half+1];
        dp[0][0] = true;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= half; j++) {
                if(nums[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[n][half];
    }
} 

/*
Space optimized DP
Notice: inner for loop iterates backward instead of forward, just like the coin change without picking a coin more than once problem.
*/
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int total = 0;
        for(int num : nums) {
            total += num;
        }
        if(total % 2 == 1) {
            return false;
        }
        int half = total/2;
        boolean[] dp = new boolean[half + 1];
        dp[0] = true;
        for(int num : nums) {
            for(int j = half; j >= 0; j--) {
                if(num <= j) {
                    dp[j] |= dp[j - num];
                }
            }
        }
        return dp[half];
    }
} 


/*
TLE backtracking solution
*/
class Solution {
    boolean[][] memo;
    int n;
    
    public boolean canPartition(int[] nums) {
        n = nums.length;
        int total = 0; 
        for(int num : nums) {
            total += num;
        }
        if(total % 2 == 1) {
            return false;
        }
        
        int half = total / 2;
        memo = new boolean[n+1][half+1];
        return partitionHelper(nums, half, 0, false);
    }
    
    private boolean partitionHelper(int[] nums, int currSum, int index, boolean ans) {
        if(index == nums.length) {
            //System.out.println(currSum);
            return currSum == 0;
        }
        
        for(int i = index; i < nums.length; i++) {
            currSum -= nums[i];
            ans |= partitionHelper(nums, currSum, i + 1, ans);
            currSum += nums[i];
        }
        return ans;
    }
}



/*
Backtracking with memo
*/
class Solution {
    Boolean[][] memo;
    int n;
    
    public boolean canPartition(int[] nums) {
        n = nums.length;
        int total = 0; 
        for(int num : nums) {
            total += num;
        }
        if(total % 2 == 1) {
            return false;
        }
        
        int half = total / 2;
        memo = new Boolean[n+1][half+1];
        
        return partitionHelper(nums, half, 0, false);
    }
    
    private boolean partitionHelper(int[] nums, int currSum, int index, boolean ans) {
        
        if(index == nums.length) {
            return currSum == 0;
        }
        
        if(currSum < 0) {
            return false;
        }
        
        for(int i = index; i < nums.length; i++) {
            currSum -= nums[i];
            if(currSum >= 0 && memo[i][currSum] !=null) {
                ans |= memo[i][currSum];
            } else {
                boolean temp = partitionHelper(nums, currSum, i + 1, ans);
                ans |= temp;
                if(currSum >= 0) {
                    memo[i][currSum] = temp;
                }
            }
            currSum += nums[i];
        }
        return ans;
    }
}



