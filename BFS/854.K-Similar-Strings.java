/*

https://leetcode.com/problems/k-similar-strings/

General idea: 
- Use BFS, find shortest path to transform s1 to s2
- Each step: swap 2 characters of s1 for each other
- Prune branches that makes s1 "more different" from s2
*/

class Solution {
    public int kSimilarity(String s1, String s2) {
        Queue<String> queue = new LinkedList<>();
        queue.add(s1);
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String top = queue.remove();
                if(top.equals(s2)) {
                    return level;
                }
                for(String neighbor : getNeighbors(top, s2)) {
                    queue.add(neighbor);
                }
            }
            level++;
        }
        return -1;
    }
    
    private List<String> getNeighbors(String top, String s2) {
        List<String> neighbors = new ArrayList<>();
        int i = 0;
        int n = top.length();
        while(i < n) {
            if(top.charAt(i) != s2.charAt(i)) {
                break;
            }
            i++;
        }
        
        for(int j = i + 1; j < n; j++) {
            if(top.charAt(j) == s2.charAt(i)) {
                top = swap(top, i, j);
                neighbors.add(top);
                top = swap(top, i, j);
            }
        }
        
        return neighbors;
    }
    
    
    private String swap(String top, int i, int j) {
        char[] arr = top.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return new String(arr);
    }
    
}
