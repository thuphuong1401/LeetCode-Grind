/*
https://leetcode.com/problems/alien-dictionary/
*/

class Solution {
    public String alienOrder(String[] words) {
        StringBuilder alphabet = new StringBuilder();
        // for Kahn's BFS: need 1. indegree count, 2. adj list
        
        // indegree count
        Map<Character, Integer> inDegree = new HashMap<>();
        // adjacency list
        Map<Character, List<Character>> graph = new HashMap<>();
        for(String word : words) {
            for(char c : word.toCharArray()) {
                inDegree.put(c, 0);
                graph.put(c, new ArrayList<>());
            }
        }
        
        int n = words.length;
        for(int i = 0; i < n-1; i++) {
            String w1 = words[i];
            String w2 = words[i+1];
            int l1 = w1.length();
            int l2 = w2.length();
            // return false if a word is succeeded by its prefix
            if(l1 > l2 && w1.startsWith(w2)) {
                return "";
            }
            // find first position where 2 consecutive words differ
            for(int j = 0; j < Math.min(l1, l2); j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if(c1 != c2) { // put an edge from w1.charAt(j) to w2.charAt(j)
                    graph.get(c1).add(c2);
                    inDegree.put(c2, inDegree.get(c2) + 1);
                    
                    break; // exit for loop when first diff position found
                }
            }
        }
        
        
        // Kahn's BFS
        Queue<Character> queue = new LinkedList<>();
        for(char c : inDegree.keySet()) {
            if(inDegree.get(c) == 0) {
                queue.add(c);
            }
        }
        
        while(!queue.isEmpty()) {
            char c = queue.remove();
            alphabet.append(c);
            for(char neighbor : graph.get(c)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if(inDegree.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }
        
        for(char c : inDegree.keySet()) {
            if(inDegree.get(c) != 0) {
                return "";
            }
        }
        
        
        return alphabet.toString();
    }
}
