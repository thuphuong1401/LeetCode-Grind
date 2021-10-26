/*
https://leetcode.com/problems/delivering-boxes-from-storage-to-ports/
*/

/*
TLE DP idea
*/
class Solution {
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        
        /*
        dp[i]: min num of trips it takes to deliver the first ith boxes
        */
        
        int n = boxes.length;
        int[] dp = new int[n];
        dp[0] = 2;
        
        for(int i = 1; i < n; i++) {
            int j = i - 1;
            dp[i] = dp[i - 1] + 2; // i mot minh 1 chuyen
            int totalTrips = 2;
            int tempMaxWeight = maxWeight - boxes[i][1];
            int tempBoxes = maxBoxes - 1;
            while(j >= 0 && tempBoxes > 0 && tempMaxWeight - boxes[j][1] >= 0) {
                if(boxes[j][0] == boxes[j + 1][0]) { // same port
                    int val = 0;
                    if(j == 0) {
                        val = totalTrips;
                    } else {
                        val = dp[j - 1] + totalTrips;
                    }
                    dp[i] = Math.min(dp[i], val);
                } else { // different port from previous box
                    totalTrips++;
                    int val = 0;
                    if(j == 0) {
                        val = totalTrips;
                    } else {
                        val = dp[j - 1] + totalTrips;
                    }
                    dp[i] = Math.min(dp[i], val);
                }
                tempBoxes--;
                tempMaxWeight -= boxes[j][1];
                j--;
            }    
        }
        
        return dp[n-1];
    }
}



