/*
https://leetcode.com/problems/word-break-ii/
*/

class Solution {
    
    List<String> answer;
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        answer = new ArrayList<>();
        Set<String> wordDictSet = new HashSet<>();
        for(String str : wordDict) {
            wordDictSet.add(str);
        }
        int n = s.length();
        breakable(s, 0, new StringBuilder(), wordDictSet);
        
        return answer;
    }
    
    private void breakable(String s, int index, StringBuilder sb, Set<String> wordDictSet) {
        int n = s.length();
        
        if(index >= n) {
            sb.setLength(sb.length() - 1);
            answer.add(sb.toString());
            return;
        }
        
        StringBuilder currWord = new StringBuilder();
        
        for(int i = index; i < n; i++) {
            currWord.append(s.charAt(i));
            if(wordDictSet.contains(currWord.toString())) {
                int prevLength = sb.length();
                sb.append(currWord);
                sb.append(" ");
                breakable(s, i + 1, sb, wordDictSet);
                sb.setLength(prevLength);
            }
        }
        
    }
}
