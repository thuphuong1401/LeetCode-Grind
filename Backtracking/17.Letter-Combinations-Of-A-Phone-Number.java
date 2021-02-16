/*
https://leetcode.com/problems/letter-combinations-of-a-phone-number/
*/
class Solution {
    List<String> answer;
    
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        answer = new ArrayList<>();
        if(digits == null || n == 0) {
            return answer;
        }
        char[][] map = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
        StringBuilder sb = new StringBuilder();
        backtracking(sb, digits, map, 0, n);
        return answer;
    }
    
    
    private void backtracking(StringBuilder sb, String digits, char[][] map, int index, int n) {
        if(index == n) {
            answer.add(sb.toString());
            return;
        }
        
        int currNum = digits.charAt(index) - '0';
        for(int i = 0; i < map[currNum].length; i++) {
            sb.append(map[currNum][i]);
            backtracking(sb, digits, map, index+1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
}
