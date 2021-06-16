/*
https://leetcode.com/problems/container-with-most-water/
Key insight:
Tang bien L, R len thanh cai nao khong the lam tang dien tich hien tai

min(L, R) = L => tang L++ (vi improve current min)
Neu ma tang R => khong improve duoc current min ma lai con giam chieu cao
Gia su tang R len thanh R' > R => min(L, R) van la L.
Gia su tang R len thanh R' < R => min(L, R) < R => dien tich giam

*/
class Solution {
    
    public int maxArea(int[] height) {
        
        int n = height.length;
        int maxArea = 0;
        int l = 0, r = n-1;
        while(l < r) {
            int currArea = (r - l) * Math.min(height[l], height[r]);
            maxArea = Math.max(maxArea, currArea);
            
            if(height[l] < height[r]) {
                l++;
            } else if(height[l] > height[r]) {
                r--;
            } else {
                if(height[l + 1] >= height[r - 1]) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        
        return maxArea;
    }
}
