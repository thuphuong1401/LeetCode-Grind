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


/*
O(N) solution with 3 passes
*/
class Solution {
    
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        
        Stack<Integer> stack = new Stack<>();
        
        int[] closestShorterColFromLeft = new int[n];
        int[] closestShorterColFromRight = new int[n];
        for(int i = 0; i < n; i++) {
            closestShorterColFromLeft[i] = i;
            closestShorterColFromRight[i] = i;
        }
        
        // find closestShorterColFromRight - increasing stack
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int x = stack.pop();
                closestShorterColFromRight[x] = i;
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            int x = stack.pop();
            closestShorterColFromRight[x] = n;
        }
        
        stack.clear();

        // find closestShorterColFromLeft - increasing stack
        for(int i = n-1; i >= 0; i--) {
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int x = stack.pop();
                closestShorterColFromLeft[x] = i;
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            int x = stack.pop();
            closestShorterColFromLeft[x] = -1;
        }
        
        int maxArea = 0;
        for(int i = 0; i < n; i++) {
            int currArea = (closestShorterColFromRight[i] - closestShorterColFromLeft[i] - 1) * heights[i];
            maxArea = Math.max(maxArea, currArea);
        }
        return maxArea;
    }
    
}


/*
Most efficient solution

Let me try to give my thought process behind using stack, hope it helps:

Idea is, we will consider every element a[i] to be a candidate for the area calculation. That is, if a[i] is the minimum element then what is the maximum area possible for all such rectangles? We can easily figure out that it's a[i]*(R-L+1-2) or a[i] * (R-L-1), where a[R] is first subsequent element(R>i) in the array just smaller than a[i], similarly a[L] is first previous element just smaller than a[i]. makes sense? (or take a[i] as a center and expand it to left and right and stop when first just smaller elements are found on both the sides). But how to implement it efficiently?

We add the element a[i] directly to the stack if it's greater than the peak element (or a[i-1] ), because we are yet to find R for this. Can you tell what's L for this? Exactly, it's just the previous element in stack. (We will use this information later when we will pop it out).

What if we get an element a[i] which is smaller than the peak value, it is the R value for all the elements present in stack which are greater than a[i]. Pop out the elements greater than a[i], we have their R value and L value(point 2). and now push a[i] and repeat..
*/
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        
        // maintain an increasing stack
        for(int i = 0; i < n; i++) {
            while(stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                int currHeight = heights[stack.pop()];
                int currWidth = i - stack.peek() - 1;
                int currArea = currHeight * currWidth;
                maxArea = Math.max(maxArea, currArea);
            }   
            stack.push(i);
        }
        
        while(stack.peek() != -1) {
            int currHeight = heights[stack.pop()];
            int currWidth = n - stack.peek() - 1;
            int currArea = currHeight * currWidth;
            maxArea = Math.max(maxArea, currArea);
        }
        
        return maxArea;
    }
}
