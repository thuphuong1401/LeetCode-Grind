/*
https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
*/


/*
My solution: time O(m * log(n))
*/
class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++) {
            count += (n - firstNegative(grid[i]));
        }
        return count;
    }
    
    private int firstNegative(int[] arr) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int ans = n;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(arr[mid] < 0) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }   
}



/*
Optimal solution: time O(m + n). Idea similar to "Leftmost column with at least a 1" or "Search in a sorted matrix"
Big idea: trace staircase pattern formed by negative numbers
*/
class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int r = m-1;
        int c = 0;
        while(r >= 0 && c < n) {
            if(grid[r][c] < 0) {
                r--;
                count += (n - c);
            } else {
                c++;
            }
        }
        return count;
    }
}



