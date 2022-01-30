/*
https://leetcode.com/problems/shortest-path-to-get-all-keys/
*/

class State {
    int x;
    int y;
    int numKeysLeft;
    int currKeys;
    
    public State(int x, int y, int numKeysLeft, int currKeys) {
        this.x = x;
        this.y = y;
        this.numKeysLeft = numKeysLeft;
        this.currKeys = currKeys;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        result = prime * result + numKeysLeft;
        result = prime * result + currKeys;
        return result;
    }
    
    @Override
    public boolean equals(Object o) {
        State other = (State) o;
        if(this.x == other.x && this.y == other.y && this.numKeysLeft == other.numKeysLeft && this.currKeys == other.currKeys) {
            return true;
        }
        return false;
    }
}

class Solution {
    public int shortestPathAllKeys(String[] originalGrid) {
        int m = originalGrid.length;
        int n = originalGrid[0].length();
        char[][] grid = new char[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                grid[i][j] = originalGrid[i].charAt(j);
            }
        }
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        int numKeys = 0;
        int[] startingGrid = new int[2];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if('a' <= grid[i][j] && grid[i][j] <= 'f') {
                    numKeys++;
                } else if(grid[i][j] == '@') {
                    startingGrid[0] = i;
                    startingGrid[1] = j;
                    grid[i][j] = '.';
                }
            }
        }
        Queue<State> queue = new LinkedList<>();
        Set<State> visited = new HashSet<>();
        State initState = new State(startingGrid[0], startingGrid[1], numKeys, 0);
        queue.add(initState);
        visited.add(initState);
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                State top = queue.remove();
                if(top.numKeysLeft == 0) {
                    return level;
                }
                for(int j = 0; j < 4; j++) {
                    int ux = top.x + dx[j];
                    int uy = top.y + dy[j];
                    State empty = new State(ux, uy, top.numKeysLeft, top.currKeys);
                    if(0 <= ux && ux < m && 0 <= uy && uy < n) { 
                        if(!visited.contains(empty) && grid[ux][uy] == '.') {
                            visited.add(empty);
                            queue.add(empty);
                        } else if ('a' <= grid[ux][uy] && grid[ux][uy] <= 'f') { // avoid double-pick a key
                            int numLeft = top.numKeysLeft;
                            int key = (int)(grid[ux][uy] - 'a');
                            if(((top.currKeys >> key) & 1) == 0) {
                                numLeft--;
                            }
                            State hasKey = new State(ux, uy, numLeft, top.currKeys |= (1 << key));
                            if(visited.contains(hasKey)) {
                                continue;
                            }
                            visited.add(hasKey);
                            queue.add(hasKey);
                        } else if ('A' <= grid[ux][uy] && grid[ux][uy] <= 'F') {
                            int key = (int)(Character.toLowerCase(grid[ux][uy]) - 'a');
                            if(((top.currKeys >> key) & 1) == 1) {
                                State unlocked = new State(ux, uy, top.numKeysLeft, top.currKeys);
                                if(visited.contains(unlocked)) {
                                    continue;
                                }
                                visited.add(unlocked);
                                queue.add(unlocked);
                            }
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
