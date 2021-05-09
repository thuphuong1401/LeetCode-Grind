/*
https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
NOTE: beware of indexing
*/

/*
My implementation
Sliding window approach
Time O(N), Space O(1)
*/
class Solution {
    
    // find minimum subarray size n - k
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int minSubarraySum = Integer.MAX_VALUE;
        int currSubarraySum = 0;
        int totalSum = 0;
        
        for(int i = 0; i < n; i++) {
            totalSum += cardPoints[i];
        }
        if(n == k) {
            return totalSum;
        }
        int length = n - k;
        int j = 0;
        for(int i = 0; i < n; i++) {
            currSubarraySum += cardPoints[i];
            int currLength = i - j + 1;
            if(currLength == length) {
                minSubarraySum = Math.min(minSubarraySum, currSubarraySum);
                currSubarraySum -= cardPoints[j];
                j++;
            }
        }
        return totalSum - minSubarraySum;
    }
}


/*
DP method
Key insight: take at most k scores from the left side of the array, and k from the right side of the array
*/
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int maxScore = 0;
        
        int leftScore = 0;
        for(int i = 0; i < k; i++) {
            leftScore += cardPoints[i];
        }
        maxScore = leftScore;
        int rightScore = 0;
        for(int i = k-1; i >= 0; i--) {
            rightScore += cardPoints[n - (k - i)];
            leftScore -= cardPoints[i];
            int currScore = leftScore + rightScore;
            maxScore = Math.max(maxScore, currScore);
        }
        
        return maxScore;
    }
}
