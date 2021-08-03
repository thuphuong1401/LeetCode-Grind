/*
https://leetcode.com/problems/excel-sheet-column-title/
Key idea: columnNumber-- at the start of the loop. Because A = 1, not A = 0. 
From string to number: n = (A + 1) * 26 ^ 3 + .... + (Z + 1)
=> From number to string: n-1 = (A + 1) * 26 ^ 3 + ... + Z => take mod. In other words, -1 before modding.
*/
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        while(columnNumber > 0) {
            columnNumber--;
            int r = columnNumber % 26;
            columnNumber /= 26;
            char c = (char)('A' + r);
            res.append(c);
        }        
        return res.reverse().toString();
    }
}
