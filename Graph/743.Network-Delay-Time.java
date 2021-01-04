/*
https://leetcode.com/problems/network-delay-time/
*/

class Node implements Comparable<Node>{
    Integer id;
    Integer dist;
    
    public Node(Integer id, Integer dist) {
        this.id = id;
        this.dist = dist;
    }
    
    @Override
    public int compareTo(Node other) {
        return this.dist.compareTo(other.dist);
    }
}


class Solution {
    static final int INF = (int) 1e9;
    List<List<Node>> graph;
    int[] dist;
    
    public int networkDelayTime(int[][] times, int N, int K) {
        graph = new ArrayList<List<Node>>();
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Node>());
        }
        for(int i = 0; i < times.length; i++) {
            int a = times[i][0];
            int b = times[i][1];
            int c = times[i][2];
            graph.get(a).add(new Node(b, c));
        }
        dist = new int[N+1];
        Arrays.fill(dist, INF);
        dijkstra(K);
        int latency = 0;
        for(int i = 1; i <= N; i++) {
            if(dist[i] == INF) {
                return -1;
            } else {
                latency = Math.max(latency, dist[i]);
            }
        }
        return latency;
    }
    
    
    public void dijkstra(int s) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[s] = 0;
        pq.add(new Node(s, 0));
        while(!pq.isEmpty()) {
            Node top = pq.remove();
            int u = top.id;    
            if(dist[u] != top.dist) {
                continue;
            }
            for(int i = 0; i < graph.get(u).size(); i++) {
                Node neighbor = graph.get(u).get(i);
                int v = neighbor.id;
                int w = neighbor.dist;
                if(dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }
    }
}
