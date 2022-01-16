/*
https://leetcode.com/problems/letter-case-permutation/
*/

class Solution {
    List<String> answer;
    
    public List<String> letterCasePermutation(String s) {
        answer = new ArrayList<>();
        int n = s.length();
        backtrack(s, n, 0, new char[n]);
        return answer;
    }
    
    private void backtrack(String s, int n, int index, char[] perm) {
        if(index >= n) {
            String newPerm = new String(perm);
            answer.add(newPerm);
            return;
        }
        
        char c = s.charAt(index);
        if('0' <= c && c <= '9') {
            perm[index] = c;
            backtrack(s, n, index + 1, perm);
        } else {
            
            // 2 choices: lowercase and uppercase
            char lowerCase = Character.toLowerCase(c);
            perm[index] = lowerCase;
            backtrack(s, n, index + 1, perm);
            
            char upperCase = Character.toUpperCase(c);
            perm[index] = upperCase;
            backtrack(s, n, index + 1, perm);
        }
    }
    
}
