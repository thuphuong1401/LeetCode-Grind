/*
https://leetcode.com/problems/shortest-word-distance/
*/

class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int p1 = -1;
        int p2 = -1;
        int minDist = Integer.MAX_VALUE;
        int n = wordsDict.length;
        for(int i = 0; i < n; i++) {
            String currWord = wordsDict[i];
            if(word1.equals(currWord)) {
                p1 = i;
            }
            
            if(word2.equals(currWord)) {
                p2 = i;
            }
            
            if(p1 != -1 && p2 != -1) {
                minDist = Math.min(minDist, Math.abs(p1 - p2));
            }
        }
        
        return minDist;
    }
}
