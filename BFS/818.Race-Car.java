/*
https://leetcode.com/problems/race-car/
*/
class Solution {
    
    public int racecar(int target) {
        Set<String> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>(); // position - speed
        
        String start = "0 1"; // pos - speed
        int[] begin = new int[]{0, 1};
        
        visited.add(start);
        queue.add(begin);
    
        int level = 0;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] top = queue.remove();
                int currPos = top[0];
                int currSpeed = top[1];
                
                if(currPos == target) {
                    return level;
                }
                
                String A = Integer.toString(currPos + currSpeed) + " " + currSpeed * 2;
                String B = "";
                if(currSpeed > 0) {
                    B = Integer.toString(currPos) + " " + Integer.toString(-1);
                } else {
                    B = Integer.toString(currPos) + " " + Integer.toString(1);
                }
                
                /*
                Important pruning condition
                A -> go over target -> make sure don't go over by more than |target|
                */
                if(Math.abs(currPos + currSpeed - target) < target && !visited.contains(A)) {
                    visited.add(A);
                    queue.add(new int[]{currPos + currSpeed, currSpeed * 2});
                }
                
                if(Math.abs(currPos - target) < target && !visited.contains(B)) {
                    visited.add(B);
                    if(currSpeed > 0) {
                        queue.add(new int[]{currPos, -1});
                    } else {
                        queue.add(new int[]{currPos, 1});
                    }
                }
                
            }
            level++;
        }
        
        return -1;
    }
}
