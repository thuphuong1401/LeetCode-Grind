/*
https://leetcode.com/problems/freedom-trail/
*/

class Solution {
    Integer[][] dp;
    
    public int findRotateSteps(String ring, String key) {
        Map<Character, List<Integer>> ringMap = new HashMap<>();
        int n = ring.length();
        for(int i = 0; i < n; i++) {
            char c = ring.charAt(i);
            if(!ringMap.containsKey(c)) {
                ringMap.put(c, new ArrayList<>());
            }
            ringMap.get(c).add(i);
        }
        int m = key.length();
        dp = new Integer[n + 1][m + 1];
        return minSteps(ring, 0, key, 0, ringMap);   
    }
    
    
    private int minSteps(String ring, int ringIndex, String key, int keyIndex, Map<Character, List<Integer>> ringMap) {
        if(keyIndex >= key.length()) {
            return 0;
        }
        
        int[] params = new int[]{ringIndex, keyIndex};
        
        if(dp[ringIndex][keyIndex] != null) {
            return dp[ringIndex][keyIndex];
        }
        
        char curr = key.charAt(keyIndex);
        
        int minSteps = 1000000;
        
        for(int pos : ringMap.get(curr)) {
            int steps = Math.min(Math.abs(ringIndex - pos), ring.length() - Math.abs(ringIndex - pos)) + 1;
            int nextSteps = minSteps(ring, pos, key, keyIndex + 1, ringMap);
            steps += nextSteps;
            minSteps = Math.min(minSteps, steps);    
        }
        
        dp[ringIndex][keyIndex] = minSteps;
        return minSteps;
    }
    
}
