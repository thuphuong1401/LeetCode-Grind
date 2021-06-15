/*
https://leetcode.com/problems/find-the-town-judge/
*/

class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] inDegree = new int[N+1];
        int[] outDegree = new int[N+1];
        for(int[] relation : trust) {
            int u = relation[0];
            int v = relation[1];
            inDegree[v]++;
            outDegree[u]++;
        }
        
        for(int i = 1; i <= N; i++) {
            if(inDegree[i] == N-1 && outDegree[i] == 0) {
                return i;
            }
        } 
        return -1;
    }
}
