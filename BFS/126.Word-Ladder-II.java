/*
https://leetcode.com/problems/word-ladder-ii/
*/

class Solution {
    
    List<List<String>> sequences;
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String word : wordList) {
            set.add(word);
        }
        Map<String, List<String>> graph = new HashMap<>();
        
        for(String word : wordList) {
            graph.put(word, new ArrayList<>());
        }
        
        graph.put(beginWord, new ArrayList<>());
        graph.put(endWord, new ArrayList<>());
        
        if(!set.contains(beginWord)) {
            wordList.add(beginWord);    
            set.add(beginWord);
        }
        
        for(String word : wordList) {
            char[] currWord = word.toCharArray();
            for(int i = 0; i < currWord.length; i++) {
                for(int j = 0; j < 26; j++) {
                    char replaceChar = (char)('a' + j);
                    currWord[i] = replaceChar;
                    String newStr = String.valueOf(currWord);
                    if(set.contains(newStr) && !newStr.equals(word)) {
                        graph.get(word).add(newStr);
                    }
                }
                currWord = word.toCharArray();
            }
        }
        
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> dist = new HashMap<>();
        
        queue.add(beginWord);
        visited.add(beginWord);
        dist.put(beginWord, 0);
        
        int minLength = 1;
        
        while(!queue.isEmpty()) {
            
            int size = queue.size();
            boolean flag = false;
            for(int i = 0; i < size; i++) {
                String popped = queue.remove();
                if(popped.equals(endWord)) {
                    flag = true;
                    break;
                }
                for(String neighbor : graph.get(popped)) {
                    if(!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                        dist.put(neighbor, dist.get(popped) + 1);
                    }
                }
            }
            
            ++minLength;
            
            
            if(flag) {
                break;
            }
            
        }
        
        if(minLength == 1) {
            return new ArrayList<>();
        }
        
        sequences = new ArrayList<>();
        
        // backtrack from endWord to startWord to reduce search space
        getPaths(dist, graph, endWord, beginWord, new ArrayList<>());

        return sequences;
    }
    
    
    private void getPaths(Map<String, Integer> dist, Map<String, List<String>> graph, String vertex, String startWord, List<String> list) {
        
        list.add(vertex);
        
        if(vertex.equals(startWord)) {
            Collections.reverse(list);
            sequences.add(new ArrayList<>(list));
            Collections.reverse(list);
            list.remove(list.size() - 1);
            return;
        }
        
        for(String neighbor : graph.get(vertex)) {
            if(dist.get(neighbor) == null) {
                continue;
            }
            if(dist.get(neighbor) == dist.get(vertex) - 1) {
                getPaths(dist, graph, neighbor, startWord, list);
            }
        }
        
        list.remove(list.size() - 1);
    }
    
    
}
