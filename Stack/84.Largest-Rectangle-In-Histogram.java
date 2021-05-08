/*
https://leetcode.com/problems/largest-rectangle-in-histogram/
*/

/*
Brute force method
Time: O(n^2) - Space O(n)
Big idea: 
- Test out all the possible pairs of columns
- Area of rectangle = (index of 2nd col - index of 1st col + 1) * min height of col between 1st and 2nd col
*/
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        for(int i = 0; i < n; i++) {
            int minHeightBetweenTwoBars = (int)1e4 + 1;
            for(int j = i; j < n; j++) {
                minHeightBetweenTwoBars = Math.min(minHeightBetweenTwoBars, heights[j]);
                int currArea = minHeightBetweenTwoBars * (j - i + 1);
                maxArea = Math.max(maxArea, currArea);
            }
        }
        return maxArea;
    }
}




