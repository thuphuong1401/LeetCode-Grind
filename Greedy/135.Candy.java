/*
https://leetcode.com/problems/candy/
*/
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n]; 
        candies[0] = 1;
        
        // thoa man dk(2) ben trai
        for(int i = 1; i < n; i++) {
            if(ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1] + 1;
            } else {
                candies[i] = 1;
            }
        }
        
        // thoa man dk(2) ben phai
        for(int i = n-2; i >= 0; i--) {
            if(ratings[i] > ratings[i+1]) {
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }
        }
        
        int numCandies = 0;
        for(int i = 0; i < n; i++) {
            numCandies += candies[i];
        }
        return numCandies;
    }
}


