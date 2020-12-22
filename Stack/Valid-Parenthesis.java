/*
https://leetcode.com/problems/valid-parentheses/
*/

class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                if(stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }                     
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
        
    }
}
