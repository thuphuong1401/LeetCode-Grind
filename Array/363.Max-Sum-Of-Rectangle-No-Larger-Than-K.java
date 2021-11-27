/*
https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/
*/

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int ans = Integer.MIN_VALUE;
        
        for(int startRow = 0; startRow < m; startRow++) {
            int[] collapse = new int[n];
            for(int endRow = startRow; endRow < m; endRow++) {
                for(int c = 0; c < n; c++) {
                    collapse[c] += matrix[endRow][c];
                }
                ans = Math.max(ans, maxSumLessThanKArray(collapse, k));
            }
        }
        
        return ans;
        
    }
    
    private int maxSumLessThanKArray(int[] arr, int k) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        int prefixSum = 0;
        int n = arr.length;
        int ans = Integer.MIN_VALUE;
        treeSet.add(0);
        for(int i = 0; i < n; i++) {
            prefixSum += arr[i];
            if(treeSet.ceiling(prefixSum - k) != null) {
                int x = treeSet.ceiling(prefixSum - k);
                ans = Math.max(ans, prefixSum - x);
            }
            treeSet.add(prefixSum);
        }
        
        return ans;
    }
    
}
