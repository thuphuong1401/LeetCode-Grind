/*
https://leetcode.com/problems/expression-add-operators/
*/

class Solution {
    List<String> answer;
    
    public List<String> addOperators(String num, int target) {
        answer = new ArrayList<>();
        backtracking(0, num, target, "", 0, 0);
        return answer;
    }
    
    /*
    i: start of an operand
    4 choices: +, -, *, no op
    Big idea: partiion num into many operands, fill + - * between each operand
    */
    private void backtracking(int i, String num, int target, String exp, long prevOperand, long resSoFar) {
        if(i >= num.length()) {
            if(resSoFar == target) {
                answer.add(exp);
                return;
            }
        }
        
        // loop through all possible length of an operand. j: end of current operand   
        for(int j = i; j < num.length(); j++) {
            // no leading 0s
            if(j > i && num.charAt(i) == '0') {
                break;
            }
            String currOp = num.substring(i, j + 1);
            long currNum = Long.parseLong(currOp);
            
            if(i == 0) {
                backtracking(j + 1, num, target, currOp, currNum, currNum);
            } else {
            
                // "+"
                backtracking(j + 1, num, target, exp + "+" + currNum, currNum, resSoFar + currNum);

                // "-"
                backtracking(j + 1, num, target, exp + "-" + currNum, -currNum, resSoFar - currNum);

                // "*"
                backtracking(j + 1, num, target, exp + "*" + currNum, prevOperand * currNum, resSoFar - prevOperand + prevOperand * currNum);
            }
        }
    }
    
}
