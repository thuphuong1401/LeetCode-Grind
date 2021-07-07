/*
https://leetcode.com/problems/jump-game-iv/
*/

class Solution {
    
    // adj(v) = {i+1, i-1, other positions with value = v}    
    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int i = 0;
        
        while(i < n-1) { // only save first and last index of a sequence of equal numbers
            int curr = arr[i];
            if(!map.containsKey(curr)) {
                map.put(curr, new HashSet<>());
            }
            map.get(curr).add(i);
            
            while(i < n-1) {
                curr = arr[i];
                int next = arr[i+1];
                if(curr == next) {
                    i++;
                    continue;
                } else {
                    map.get(curr).add(i);
                    break;
                }
            }
            
            i++;
        }    
        
        
        if(!map.containsKey(arr[n-1])) {
            map.put(arr[n-1], new HashSet<>());
        }
    
        map.get(arr[n-1]).add(n-1);
        
        
        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        for(int v = 0; v < n; v++) {
            adjList.put(v, new HashSet<>());
            if(v > 0) {
                adjList.get(v).add(v-1);
            }
            if(v < n-1) {
                adjList.get(v).add(v+1);
            }
        }
        
        int numJumps = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        // very powerful
        boolean[] visited = new boolean[n];
        visited[0] = true;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int s = 0; s < size; s++) {
                int top = queue.remove();
                
                if(top == n-1) {
                    return numJumps;    
                }
                
                for(int neighbor : adjList.get(top)) {
                    if(!visited[neighbor]) {
                        queue.add(neighbor);
                        visited[neighbor] = true;
                    }
                }
                
                int valueOfTop = arr[top];
                for(int neighbor : map.get(valueOfTop)) {
                    if(!visited[neighbor]) {
                        queue.add(neighbor);
                        visited[neighbor] = true;
                    }
                } 
            }
            
            numJumps++;
        }
        
        return 0;
    }
}

