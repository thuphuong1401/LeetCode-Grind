/*
https://leetcode.com/problems/buildings-with-an-ocean-view/
*/
class Solution {
    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxHeightSoFar = Integer.MIN_VALUE;
        for(int i = n-1; i >= 0; i--) {
            int currHeight = heights[i];
            if(currHeight > maxHeightSoFar) {
                stack.push(i);
                maxHeightSoFar = currHeight;
            }
        }
        int m = stack.size();
        int[] answer = new int[m];
        for(int i = 0; i < m; i++) {
            answer[i] = stack.pop();
        }
        return answer;
        
        
    }
}
