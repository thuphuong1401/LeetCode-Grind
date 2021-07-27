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


/*
Another smarter version without the tricky condition
*/
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int time = 0;
        
        int leftBound = 0;
        int rightBound = n-1;
        int topBound = 0;
        int bottomBound = m-1;
        
        List<Integer> result = new ArrayList<>();
        
        while(result.size() < m*n) {
            
            // top
            for(int i = leftBound; i <= rightBound && result.size() < m*n; i++) {
                result.add(matrix[topBound][i]);
            }
            
            topBound++;
            
            // right
            for(int i = topBound; i <= bottomBound && result.size() < m*n; i++) {
                result.add(matrix[i][rightBound]);
            }
            
            rightBound--;
            
            // bottom
            for(int i = rightBound; i >= leftBound && result.size() < m*n; i--) {
                result.add(matrix[bottomBound][i]);
            }
            
            
            bottomBound--;
            
            // left
            for(int i = bottomBound; i >= topBound && result.size() < m*n; i--) {
                result.add(matrix[i][leftBound]);

            }
            
            leftBound++;
        }
        
        return result;
    }
}

