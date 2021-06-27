/*
https://leetcode.com/problems/word-ladder/
*/

class Solution {
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
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
        
        //System.out.println(graph);
        
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visited.add(beginWord);
        
        int minLength = 1;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String popped = queue.remove();
                if(popped.equals(endWord)) {
                    return minLength;
                }
                for(String neighbor : graph.get(popped)) {
                    if(!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
            ++minLength;
        }
        
        return 0;
    }
}
