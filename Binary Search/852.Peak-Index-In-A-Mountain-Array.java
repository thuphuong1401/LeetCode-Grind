/*
https://leetcode.com/problems/peak-index-in-a-mountain-array/
*/

// O(n) straightforward solution
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int max = arr[0];
        int maxIndex = 0;
        
        for(int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            if(curr > max) {
                max = curr;
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}


// Binary search O(log n)
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while(left < right) {
            int mid = left + (right - left)/2;
            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) {
                return mid;
            } else if (arr[mid] < arr[mid+1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }
}
