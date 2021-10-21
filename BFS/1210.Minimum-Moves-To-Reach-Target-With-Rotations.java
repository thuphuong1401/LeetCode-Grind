/*
https://leetcode.com/problems/minimum-moves-to-reach-target-with-rotations/
*/

class Position {
    int[] first;
    int[] second;
    
    public Position(int[] first, int[] second) {
        this.first = first;
        this.second = second;
    }
    
    public String toString() {
        return Integer.toString(first[0]) + " " + Integer.toString(first[1]) + "; " + Integer.toString(second[0]) + " " + Integer.toString(second[1]); 
    }
    
    public int direction() {
        if(first[0] == second[0]) {
            return 0; // horizontal
        } else {
            return 1; // vertical
        }
    }
}


class Solution {
    
    public int minimumMoves(int[][] grid) {
        int n = grid.length;
        Queue<Position> queue = new LinkedList<>();
        int[] firstPos = new int[]{0, 0};
        int[] secondPos = new int[]{0, 1};
        Position startPos = new Position(firstPos, secondPos);
        queue.add(startPos);
        Set<String> visited = new HashSet<>();
        visited.add(startPos.toString());
        int numMoves = 0;
        
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Position top = queue.remove();
                if(isEndPos(top, n)) {
                    return numMoves;
                }
                
                if(top.direction() == 0) { // horizontal
                    // right
                    int[] right = new int[]{top.second[0], top.second[1] + 1};
                    Position rightPos = new Position(top.second, right);
                    if(checkBound(n, right) && grid[right[0]][right[1]] == 0 && !visited.contains(rightPos.toString())) {
                        queue.add(rightPos);
                        visited.add(rightPos.toString());
                    }
                    
                    // down
                    int[] down1 = new int[]{top.first[0] + 1, top.first[1]};
                    int[] down2 = new int[]{top.second[0] + 1, top.second[1]};
                    Position downPos = new Position(down1, down2); 
                    if(checkBound(n, down1) && checkBound(n, down2) && grid[down1[0]][down1[1]] == 0 && grid[down2[0]][down2[1]] == 0 && !visited.contains(downPos.toString())) {
                        queue.add(downPos);
                        visited.add(downPos.toString());
                    }
                    
                    // clockwise
                    int[] clockwise1 = new int[]{top.first[0] + 1, top.first[1]};
                    int[] clockwise2 = new int[]{top.second[0] + 1, top.second[1]};
                    Position clockwisePos = new Position(top.first, clockwise1);
                    if(checkBound(n, clockwise1) && checkBound(n, clockwise2) && grid[clockwise1[0]][clockwise1[1]] == 0 && grid[clockwise2[0]][clockwise2[1]] == 0 && !visited.contains(clockwisePos.toString())) {
                        queue.add(clockwisePos);
                        visited.add(clockwisePos.toString());
                    }

                } else {
                    
                    // right
                    int[] right1 = new int[]{top.first[0], top.first[1] + 1};
                    int[] right2 = new int[]{top.second[0], top.second[1] + 1};
                    Position rightVertPos = new Position(right1,right2);
                    if(checkBound(n, right1) && checkBound(n, right2) && grid[right1[0]][right1[1]] == 0 &&  grid[right2[0]][right2[1]] == 0 && !visited.contains(rightVertPos.toString())) {
                        queue.add(rightVertPos); 
                        visited.add(rightVertPos.toString());
                    }
                    
                    // down
                    int[] down = new int[]{top.second[0] + 1, top.second[1]};
                    Position downVertPos = new Position(top.second, down);
                    if(checkBound(n, down) && grid[down[0]][down[1]] == 0 && !visited.contains(downVertPos.toString())) {
                        queue.add(new Position(top.second, down)); 
                        visited.add(downVertPos.toString());
                    }
                    
                    // counterclockwise
                    int[] cc1 = new int[]{top.first[0], top.first[1] + 1};
                    int[] cc2 = new int[]{top.second[0], top.second[1] + 1};
                    Position ccPos = new Position(top.first, cc1);
                    if(checkBound(n, cc1) && checkBound(n, cc2) && grid[cc1[0]][cc1[1]] == 0 && grid[cc2[0]][cc2[1]] == 0 && !visited.contains(ccPos.toString())) {
                        queue.add(ccPos);
                        visited.add(ccPos.toString());
                    }
                }
            }
            numMoves++;
        }
        return -1;
    }
    
    private boolean checkBound(int n, int[] pos) {
        if(pos[0] < n && pos[1] < n) {
            return true;
        }
        return false;
    }
    
    private boolean isEndPos(Position currPos, int n) {
        int[] first = currPos.first;
        int[] second = currPos.second;
        if((first[0] == n-1 && first[1] == n-2 && second[0] == n-1 && second[1] == n-1) ||
          first[0] == n-1 && first[1] == n-1 && second[0] == n-1 && second[1] == n-2) {
            return true;
        }
        return false;
    }
    
}
