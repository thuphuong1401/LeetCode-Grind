/*
https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/

Big idea: 
- Loop left to right, right to left
- Left to right: make sure number of '(' is GREATER THAN OR EQUAL TO number of ')'
- Right to left: make sure number of ')' is GREATER THAN OR EQUAL TO number of '('
*/

class Solution {
    
    public String minRemoveToMakeValid(String s) {
        s = remove(s, '(', ')');
        System.out.println(s);
        s = remove(reverse(s), ')', '(');
        return reverse(s);
    }
    
    private String remove(String s, char bal1, char bal2) {
        StringBuilder sb = new StringBuilder();
        int balance = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == bal1) {
                balance++;
            } else if(c == bal2) {
                balance--;
                if(balance < 0) {
                    balance = 0;
                    continue;
                }
            }   
            sb.append(c);
        }
        return sb.toString();
    }
    
    private String reverse(String input) {
        StringBuilder sb = new StringBuilder();
        for(int i = input.length() - 1; i >= 0; i--) {
            sb.append(input.charAt(i));
        }
        return sb.toString();
    }
}
