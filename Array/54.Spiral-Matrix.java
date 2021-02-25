/*
https://leetcode.com/problems/spiral-matrix/
*/

/*
Inclusive index, watch out for the case bottom row and left column cause you may count the visited ones.
*/
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        
        while(rowStart <= rowEnd && colStart <= colEnd) {
            // top row
            for(int i = colStart; i <= colEnd; i++) {
                answer.add(matrix[rowStart][i]);
            }
            rowStart++;
            
            // right column
            for(int i = rowStart; i <= rowEnd; i++) {
                answer.add(matrix[i][colEnd]);
            }
            colEnd--;
            
            // bottom row
            if(rowStart <= rowEnd) {
                for(int i = colEnd; i >= colStart; i--) {
                    answer.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            }
            
            // left column
            if(colStart <= colEnd) {
                for(int i = rowEnd; i >= rowStart; i--) {
                    answer.add(matrix[i][colStart]);
                }
                
                colStart++;
            }
        }
        
        return answer;
    }
}




