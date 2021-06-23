/*
https://leetcode.com/problems/frog-jump/
*/

/*
My implementation - DP with memoization
Simulate all paths that the frog can move. If any path ends on the last stone, return true
*/
class Solution {
    Map<Integer, Integer> stonesMap;
    Map<String, Boolean> dp;
    
    public boolean canCross(int[] stones) {
        int n = stones.length;
        dp = new HashMap<>();
        if(stones[1] > 1) {
            return false;
        }
        stonesMap = new HashMap<>();
        for(int i = 0; i < n; i++) {
            stonesMap.put(stones[i], i);
        }
        return cross(stones, stones[1], 1); // (currPos, previous steps)
    }

    
    private boolean cross(int[] stones, int pos, int prevSteps) {
        
        if(pos <= 0 || pos > stones[stones.length - 1] || !stonesMap.containsKey(pos)) {
            return false;
        }
        
        if(pos == stones[stones.length - 1]) {
            return true;
        }
        
        //int[] currParams = new int[]{pos, prevSteps};
        String currParams = Integer.toString(pos) + " " + Integer.toString(prevSteps);
        if(dp.containsKey(currParams)) {
            return dp.get(currParams);
        }
        
        for(int numSteps = prevSteps - 1; numSteps <= prevSteps + 1; numSteps++) {
            if(numSteps == 0) {
                continue;
            }
            pos += numSteps;
            boolean ans = cross(stones, pos, numSteps);
            if(!ans) {
                pos -= numSteps;
            } else {
                //int[] p = new int[]{pos, prevSteps};
                String p = Integer.toString(pos) + " " + Integer.toString(prevSteps);
                dp.put(p, true);
                return true;
            }
        }
        

        //int[] params = new int[]{pos, prevSteps};
        String params = Integer.toString(pos) + " " + Integer.toString(prevSteps);
        //Pair params = new Pair(pos, prevSteps);
        dp.put(params, false);
        
        return false;
        
    }
    
    
}
