/*
https://leetcode.com/problems/minimum-deletion-cost-to-avoid-repeating-letters/
Key observation: for sequences with many similar characters standing next to each other, delete all characters except for the costliest one. 
*/

class Solution {
    public int minCost(String s, int[] cost) {
        int n = s.length();
        int totalCost = 0;
        int i = 1;
        while(i < n) {
            if(s.charAt(i-1) == s.charAt(i)) {
                int j = i;
                int maxSameCharacterCost = cost[j-1];
                int currCost = cost[j-1];
                while(j < n && s.charAt(j) == s.charAt(j-1)) {
                    currCost += cost[j];
                    maxSameCharacterCost = Math.max(maxSameCharacterCost, cost[j]);
                    j++;
                }
                currCost -= maxSameCharacterCost;
                totalCost += currCost;
                i = j+1;
            } else {
                i++;   
            }
        }
        
        return totalCost;
    }
}
