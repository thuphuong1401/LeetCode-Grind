/*
https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
Approach: at a character, currDepth = number of opening parenthesis before it - number of closing parenthesis after it.
*/
class Solution {
    public int maxDepth(String s) {
        int res = 0;
        int currDepth = 0;
        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if(curr == '(') {
                currDepth++;
                res = Math.max(res, currDepth);
            } else if(curr == ')') {
                currDepth--;
            }
        }
        return res;
    }
}
