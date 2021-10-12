/*
https://leetcode.com/problems/different-ways-to-add-parentheses/
*/

class Solution {
    
    int n;
    
    public List<Integer> diffWaysToCompute(String expression) {
        n = expression.length();
        List<Integer> result = backtracking(expression, 0, n - 1);
        return result;
    }
    
    /*
    Key idea (divide and conquer):
    - Split expression at operators
    - Obtain all possible result of expression[left, op] and expression[op, right]
    - Combine result of the 2 lists using op.
    */
    private List<Integer> backtracking(String expression, int left, int right) {        
        List<Integer> temp = new ArrayList<>();
        
        if(allNumbers(expression, left, right)) {
            temp.add(getNumber(expression, left, right));
            return temp;
        }
        
        for(int k = left; k <= right; k++) {
            char op = expression.charAt(k);
            if(isOperator(op)) {
                List<Integer> resultLeft = backtracking(expression, left, k - 1);
                List<Integer> resultRight = backtracking(expression, k + 1, right);
                for(int num1 : resultLeft) {
                    for(int num2: resultRight) {
                        int val = convert(op, num1, num2);
                        temp.add(val);
                    }
                }
            }
        }   
        return temp;
    }
    
    private boolean allNumbers(String expression, int left, int right) {
        for(int i = left; i <= right; i++) {
            if(isOperator(expression.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    private int getNumber(String expression, int left, int right) {
        StringBuilder sb = new StringBuilder();
        for(int i = left; i <= right; i++) {
            sb.append(expression.charAt(i));
        }
        return Integer.parseInt(sb.toString());
    }
    
        
    private boolean isOperator(char op) {
        return op == '+' || op == '-' || op == '*';
    }
    
    private int convert(char op, int num1, int num2) {
        if(op == '+') {
            return num1 + num2;
        } else if(op == '-') {
            return num1 - num2;
        } else if(op == '*') {
            return num1 * num2;
        }
        return 0;
    }
    
}
