/*
https://leetcode.com/problems/rotating-the-box/
*/

class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        
        char[][] res = new char[n][m];
        
        // rotaet 90 degrees
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                res[j][m-1-i] = box[i][j];
            }
        }
        
        // let it fall
        for(int col = 0; col < m; col++) {
            int available = n-1;
            for(int row = n-1; row >= 0; row--) {
                if(res[row][col] == '#') {
                    res[row][col] = '.';
                    res[available][col] = '#';
                    available--;
                } else if(res[row][col] == '*') {
                    available = row - 1;
                } 
            }
        }
        
        return res;
        
    }
}

