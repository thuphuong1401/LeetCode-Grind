/*
https://leetcode.com/problems/decode-string/
*/

class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c == ']') {
                StringBuilder temp = new StringBuilder();
                while(!stack.isEmpty() && stack.peek() != '[') {
                    temp.append(stack.pop());
                }
                stack.pop();
                StringBuilder tempNum = new StringBuilder();
                while(!stack.isEmpty() && 0 <= stack.peek() - '0' && stack.peek() - '0' <= 9) {
                    tempNum.append(stack.pop());
                }
                int num = Integer.parseInt(tempNum.reverse().toString());
                
                String reversedTemp = temp.reverse().toString();
                for(int j = 0; j < num; j++) {
                    for(char curr : reversedTemp.toString().toCharArray()) {
                        stack.push(curr);
                    }
                }
            } else {
                stack.push(c);
            }
        }
        
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        return sb.reverse().toString();
    }
}
