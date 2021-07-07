/*
https://leetcode.com/problems/jump-game-v/
*/
class Solution {
    Integer[] dp;
    
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        if(n == 1) {
            return 1;
        }
        dp = new Integer[n];
        int ans = -1;
        for(int i = 0; i < n; i++) {
            ans = Math.max(ans, maxHelper(arr, i, d));
        }
        return ans;
    }
       
    
    private int maxHelper(int[] arr, int index, int d) { // => int : max jumps possible from ind
        if((index == 0 && arr[index + 1] >= arr[index]) || (index == arr.length - 1 && arr[index - 1] >= arr[index]) || (1 <= index && index <= arr.length - 1 && arr[index - 1] >= arr[index] && arr[index + 1] >= arr[index])) {
            return 1;
        }

        if(dp[index] != null) {
            return dp[index];
        }

        int numJumps = 1;
        for(int i = index+1; i <= index + d && i < arr.length; i++) {
            if(arr[i] >= arr[index]) {
                break;
            }
            numJumps = Math.max(numJumps, maxHelper(arr, i, d) + 1);
        }


        for(int i = index-1; i >= index - d && i >= 0; i--) {
            if(arr[i] >= arr[index]) {
                break;
            }
            numJumps = Math.max(numJumps, maxHelper(arr, i, d) + 1);
        }

        dp[index] = numJumps;
        return numJumps;
    }
    
}


