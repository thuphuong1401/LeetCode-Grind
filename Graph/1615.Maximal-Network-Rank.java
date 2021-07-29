/*
https://leetcode.com/problems/maximal-network-rank/
*/

/*
O(N^2) time solution
This is the only solution possible - No O(N) solution is possible.
See discussion for more details. Look at test case 81/82 (one of the test cases I failed when trying to write a O(N) solution) to understand why.

Wrong approach: get the first max rank city and second max rank city. If they are connected, subtract 1.
Why? Because there can be multiple cities qualified for being first max in rank. If chosen the wrong city => second max will be affected.
*/
class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int u = 0; u < n; u++) {
            graph.put(u, new HashSet<>());
        }
        for(int[] road : roads) {
            int u = road[0];
            int v = road[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int maxRank = -1;
        for(int u = 0; u < n; u++) {
            for(int v = 0; v < n; v++) {
                if(u == v) {
                    continue;
                }
                int rankU = graph.get(u).size();
                int rankV = graph.get(v).size();
                int totalRank = rankU + rankV;
                if(graph.get(u).contains(v)) {
                    totalRank--;
                }
                maxRank = Math.max(maxRank, totalRank);
            }
        }
        return maxRank;
    }
}


