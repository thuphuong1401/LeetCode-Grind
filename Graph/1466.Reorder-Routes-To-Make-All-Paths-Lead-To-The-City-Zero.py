# https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/

class Solution:
    def minReorder(self, n: int, connections: List[List[int]]) -> int:
        graph = {}
        for u in range(n):
            graph[u] = []
        for edge in connections:
            u = edge[0]
            v = edge[1]
            graph[u].append(v)
            graph[v].append(u)
            
        self.directed_graph = {}
        for u in range(n):
            self.directed_graph[u] = []
        for edge in connections:
            u = edge[0]
            v = edge[1]
            self.directed_graph[u].append(v)
        
        self.visited = [False for _ in range(n)]
        self.num_reverse_edges = 0
        self.dfs(graph, 0, connections)
        return self.num_reverse_edges
        
        
    def dfs(self, graph, u, connections):
        self.visited[u] = True
        for v in graph[u]:
            if not self.visited[v]:
                if v in self.directed_graph[u]:
                    self.num_reverse_edges += 1
                self.dfs(graph, v, connections)
