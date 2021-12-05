/*
https://leetcode.com/problems/max-chunks-to-make-sorted-ii/

Big idea: when maxFromLeft[i] < minFromRight[i + 1], we can make a new chunk
*/
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        if(n == 1) {
            return 1;
        }
        int maxChunks = 1;
        
        int[] maxFromLeft = new int[n];
        maxFromLeft[0] = arr[0];
        for(int i = 1; i < n; i++) {
            maxFromLeft[i] = Math.max(maxFromLeft[i-1], arr[i]);
        }
        
        int[] minFromRight = new int[n];
        minFromRight[n-1] =  arr[n-1];
        for(int i = n-2; i >= 0; i--) {
            minFromRight[i] = Math.min(minFromRight[i + 1], arr[i]);
        }
        
        for(int i = 0; i < n - 1; i++) {
            if(maxFromLeft[i] <= minFromRight[i + 1]) {
                maxChunks++;
            }
        }
        
        return maxChunks;
    }
}
