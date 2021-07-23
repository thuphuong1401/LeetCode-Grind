# https://leetcode.com/problems/making-a-large-island/

import queue

class Solution:
    
    def largestIsland(self, grid: List[List[int]]) -> int:
        
        n = len(grid)
        
        # not visited => components[i][j] = -1
        components = [[-1 for _ in range(n)] for _ in range(n)] # syntax
        component_index = 0
        
        
        self.dx = [-1, 1, 0, 0]
        self.dy = [0, 0, -1, 1]
        self.component_size = {}
        
        for i in range(n):
            for j in range(n):
                if components[i][j] == -1 and grid[i][j] == 1:
                    self.BFS(grid, components, i, j, component_index)
                    component_index += 1
                    
        if len(self.component_size.keys()) == 0:
            return 1
        
        max_island_size = max([self.component_size[k] for k in  self.component_size.keys()])
        
        for i in range(n):
            for j in range(n):
                if grid[i][j] == 0:
                    size = 1
                    added = set()
                    for k in range(4):
                        ux = i + self.dx[k]
                        uy = j + self.dy[k]
                        if self.check_bounds(n, ux, uy) and grid[ux][uy] == 1:
                            c_index = components[ux][uy]
                            if c_index not in added:
                                added.add(c_index)
                                size += self.component_size[c_index]
                    max_island_size = max(max_island_size, size)
                
        return max_island_size
                
        
    def BFS(self, grid, components, i, j, component_index):
        q = queue.Queue()
        components[i][j] = component_index
        size = 0
        q.put((i, j))
        n = len(grid)
        while len(q.queue) > 0:
            top = q.get()
            size += 1
            for k in range(4):
                ux = top[0] + self.dx[k]
                uy = top[1] + self.dy[k]
                if self.check_bounds(n, ux, uy) and components[ux][uy] == -1 and grid[ux][uy] == 1:
                    q.put((ux, uy))
                    components[ux][uy] = component_index
                    
        self.component_size[component_index] = size
        
    
    def check_bounds(self, n, ux, uy):
        return (0 <= ux and ux < n and 0 <= uy and uy < n)
