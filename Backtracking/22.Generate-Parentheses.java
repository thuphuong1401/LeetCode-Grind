/*
https://leetcode.com/problems/generate-parentheses/
*/

class Solution {
    
    List<String> answer;
    
    // open: number of unclosed parenthesis
    public List<String> generateParenthesis(int n) {
        answer = new ArrayList<>();
        char[] s = new char[2*n];
        gen(s, 0, 0, n);
        return answer;
    }
    
    // i: vị trí cần đặt ngoặc (không phải đã đặt rồi), hence i == 2*n
    public void gen(char[] s, int i, int open, int n) {
        if(i == 2*n) {
            if(open == 0) {
                answer.add(String.valueOf(s));
            }
            
            return;
        }
        
        // open paren at i
        s[i] = '(';
        
        // open paren at i+1
        gen(s, i+1, open+1, n);
        
        // close paren at i
        if(open > 0) {
            s[i] = ')';
            gen(s, i+1, open-1, n); // 1 paren has been closed, hence open-1
        }
    }
}
