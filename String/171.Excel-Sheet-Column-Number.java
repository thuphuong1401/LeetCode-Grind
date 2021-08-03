/*
https://leetcode.com/problems/excel-sheet-column-number/
*/

class Solution {
    public int titleToNumber(String columnTitle) {
        int n = columnTitle.length();
        int res = 0;
        for(int i = 0; i < n; i++) {
            char curr = columnTitle.charAt(i);
            res += (curr - 'A' + 1) * Math.pow(26, n-1-i);
        }
        return res;
    }
}
