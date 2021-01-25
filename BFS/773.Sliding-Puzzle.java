/*
https://leetcode.com/problems/sliding-puzzle/
*/

/ Time complexity: O(R * C * (R * C)!) 
  Space complexity: O(R * C * (R * C)!) 
  => there are (R * C)! board states, each board has R*C cells
*/

class Solution {
    public int slidingPuzzle(int[][] board) {
        int m = board.length; 
        int n = board[0].length;
        
        String target = "123450";
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                sb.append(board[i][j]);
            }
        }
        
        String start = sb.toString();
        
        // up, down, left, right
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        int minSteps = 0;
        
        // position in string => position on board => position in string
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int k = 0; k < size; k++) {
                String top = queue.remove();
                if(top.equals(target)) {
                    return minSteps;
                }
                
                int blankPosition = top.indexOf("0");
                int rowOfBlank = blankPosition / n;
                int colOfBlank = blankPosition % n;
                
                for(int i = 0; i < 4; i++) {
                    int row = rowOfBlank + dx[i];
                    int col = colOfBlank + dy[i];
                    
                    if(0 <= row && row < m && 0 <= col && col < n) {
                        String nextMove = swap(top, blankPosition, row * n + col);
                        if(!visited.contains(nextMove)) {
                            visited.add(nextMove);
                            queue.add(nextMove);
                        }
                    }
                }
            }
            minSteps++;
        }
        
        return -1;
        
    }
    
    
    public String swap(String s, int i, int j) {
        char[] charS = s.toCharArray();
        char temp = charS[i];
        charS[i] = charS[j];
        charS[j] = temp;
        return new String(charS);
    }
    
}
