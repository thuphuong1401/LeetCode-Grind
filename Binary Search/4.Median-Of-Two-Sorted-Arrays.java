/*
https://leetcode.com/problems/median-of-two-sorted-arrays/
*/

// Brute force
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] temp = new int[n+m];
        for(int i = 0; i < n; i++) {
            temp[i] = nums1[i];
        }
        
        for(int i = 0; i < m; i++) {
            temp[n+i] = nums2[i];
        }
        
        Arrays.sort(temp);
        if(temp.length % 2 == 1) {
            return temp[temp.length / 2];
        } else {
            return ((double)temp[temp.length/2 - 1] + (double)temp[temp.length/2]) / 2;
        }
    }
}
