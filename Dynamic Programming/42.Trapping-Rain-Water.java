/*
https://leetcode.com/problems/trapping-rain-water/
*/

/*
My implementation. Time O(n) - Space O(n)
Big idea: 
- totalWater += water accumulated at height[i]
- water accumulated at height[i] = min(max height so far from the left, max height so far from the right) - height[i]
*/
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if(n <= 1) {
            return 0;
        }
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        
        leftMax[0] = height[0];
        for(int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        
        rightMax[n-1] = height[n-1];
        for(int i = n-2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }
        
        int ans = 0;
        for(int i = 0; i < n; i++) {
            ans += (Math.min(leftMax[i], rightMax[i]) - height[i]);
        }
        return ans;
    }
}


/*
The more optimized implementation. Time O(n) - Space O(1)
"Lower envelop technique" - Should think of binary search or two pointers
Intuition: calculate g(i) = min(max(h[1...i], max(h[i...n]))
2 pointers - get the min of both pointers. 
*/
class Solution {
    
    public int trap(int[] height) {
        int n = height.length;
        if(n <= 2) {
            return 0;
        }
        int i = 0;
        int j = n-1;
        int lmax = height[i];
        int rmax = height[j];
        int totalWater = 0;
        
        while(i <= j) {
            lmax = Math.max(lmax, height[i]);
            rmax = Math.max(rmax, height[j]);
            if(lmax <= rmax) {
                totalWater += (lmax - height[i]);
                i++;
            } else {
                totalWater += (rmax - height[j]);
                j--;
            }
        }
        return totalWater;
    }
}


