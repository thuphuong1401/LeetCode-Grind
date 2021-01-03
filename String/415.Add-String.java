/*
https://leetcode.com/problems/add-strings/
*/

class Solution {
    public String addStrings(String num1, String num2) {
        
        StringBuilder str = new StringBuilder();
        
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while(i >= 0 || j >= 0) {
            int n1 = 0;
            int n2 = 0;
            if(i >= 0) {
                n1 = num1.charAt(i) - '0';
            } 
            if(j >= 0) {
                n2 = num2.charAt(j) - '0';
            }
            int toAdd = (n1 + n2 + carry) % 10;
            carry = (n1 + n2 + carry) / 10;
            
            i--;
            j--;
            
            str.append(toAdd);
        }
        
        if(carry != 0) {
            str.append(carry);
        }
        
        return str.reverse().toString();
    }
}
