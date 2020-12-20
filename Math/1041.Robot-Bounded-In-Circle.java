/*
Fact: after at most 4 cycles, the limit cycle trajectory returns to the initial point (0, 0)
(related to the fact of having 4 directions N, W, E, S)
Cycle iff:
1. Robot returns to the initial point after 1 cycle
OR
2. Robot DOESN'T FACE NORTH
face north => no cycle

2 important facts, with mathematical proof in the solution
- If the robot doesn't face north at the end of the first cycle, then that's the limit cycle trajectory.
- After at most 4 cycles, the limit cycle trajectory returns to the initial point.
*/

class Point {
    int x;
    int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


class Solution {
    public boolean isRobotBounded(String instructions) {
        int direction = 0; // 0 - 1 - 2 - 3 (up - down - left - right)
        Point endPoint = new Point(0, 0);
        for(int i = 0; i < instructions.length(); i++) {
            char c = instructions.charAt(i);
            if(c == 'G') {
                switch(direction) {
                    case 0:
                        endPoint.y += 1;
                        break;
                    case 1:
                        endPoint.y -= 1;
                        break;
                    case 2:
                        endPoint.x -= 1;
                        break;
                    case 3:
                        endPoint.x += 1;
                        break;
                    default:
                        break;
                }
            } else if(c == 'L') {
                switch(direction) {
                    case 0:
                        direction = 2;
                        break;
                    case 1:
                        direction = 3;
                        break;
                    case 2:
                        direction = 1;
                        break;
                    case 3:
                        direction = 0;
                        break;
                    default:
                        break;
                }
            } else {
                switch(direction) {
                    case 0:
                        direction = 3;
                        break;
                    case 1:
                        direction = 2;
                        break;
                    case 2:
                        direction = 0;
                        break;
                    case 3:
                        direction = 1;
                        break;
                    default:
                        break;
                }
            }
        }
        
        // after 1 cycle: robot returns to initial position or robot doesn't face north => robot goes round!
        if(endPoint.x == 0 && endPoint.y == 0 || direction != 0) {
            return true;
        }
        return false;
    }
}
