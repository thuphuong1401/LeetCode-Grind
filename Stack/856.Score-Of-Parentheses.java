/*
https://leetcode.com/problems/score-of-parentheses/
*/

class Solution {
    public int scoreOfParentheses(String s) {
        int n = s.length();
        Stack<String> stack = new Stack<>();
        int res = 0;
        
        for(int i = 0; i < n; i++) {
            
            String curr = Character.toString(s.charAt(i));
            
            if(curr.equals("(")) {
                stack.push("(");
            } else {
                if(stack.peek().equals("(")) { 
                    stack.pop();
                    stack.push("1");
                } else {
                    int temp = 0;
                    while(!stack.isEmpty() && !stack.peek().equals("(")) {
                        String top = stack.pop();
                        temp += Integer.parseInt(top);
                    }
                    stack.pop(); // remove '('
                    
                    temp *= 2;
                    
                    stack.push(Integer.toString(temp));
                }
            }
        }
        
        while(!stack.isEmpty()) {
            res += Integer.parseInt(stack.pop());
        }
        return res;
    }
    
}

