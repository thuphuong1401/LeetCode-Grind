/*
https://leetcode.com/problems/largest-divisible-subset/
A reformulation of the longest increasing subsequence problem
*/
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n]; // answer to our problem with subset of nums[0...i] that consists of nums[i] 
        int ansSize = 0;
        int ansIndex = -1;
        Arrays.fill(dp, 1); // base case: every element is a subset of itself
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if(dp[i] > ansSize) {
                ansSize = dp[i];
                ansIndex = i;
            }
        }
        
        for(int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i : dp) {
            System.out.print(i + " ");
        }
        
        List<Integer> ans = new ArrayList<>();
        int prev = nums[ansIndex];
        while(ansIndex >= 0 && ansSize > 0) {
            if(dp[ansIndex] == ansSize && prev % nums[ansIndex] == 0) {
                ans.add(nums[ansIndex]);
                ansSize--;
                prev = nums[ansIndex];
            }
            ansIndex--;
        }        
        return ans;
    }
}

/*
dp[i]: ans khi set(0 ... i) va chua nums[i]

dp[0] = 1;
dp[1] = 2;
dp[2] = 3;
dp[3] = 4;
dp[4] = 4;
dp[5] = Math.max(dp[4], 5) = 5;
dp[6] = 5;
dp[7] = 5;
dp[8] = 6;


dp[i] = max(dp[j]) + 1, 0 <= j <= i-1
        nums[i] % nums[j] == 0
*/
