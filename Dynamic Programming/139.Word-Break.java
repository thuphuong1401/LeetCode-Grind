/*
https://leetcode.com/problems/word-break/
*/

class Solution {
    Boolean[] dp; // dp[i] = whether str[i...n-1] is 'breakable' into wordDict
    
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>();
        for(String word : wordDict) {
            wordDictSet.add(word);
        }
        
        dp = new Boolean[s.length() + 1];
        
        boolean ans = breakable(s, 0, wordDictSet);
        
        return ans;
    }
    
    
    private boolean breakable(String s, int index, Set<String> wordDictSet) {
        int n = s.length();
        
        if(index >= n) {
            return true;
        }
        
        if(dp[index] != null) {
            return dp[index];
        }
        
        StringBuilder currWord = new StringBuilder();
        
        for(int i = index; i < n; i++) {
            currWord.append(s.charAt(i));
            if(wordDictSet.contains(currWord.toString())) {
                boolean ans = breakable(s, i + 1, wordDictSet);
                if(!ans) {
                    continue;
                } else {
                    dp[index] = true;
                    return true;
                }
            } 
        }
        
        dp[index] = false;
        return false;
        
    }
}
