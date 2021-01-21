/*
https://leetcode.com/problems/add-binary/
*/
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int currA = 0, currB = 0, currSum = 0, carry = 0;
        
        while(i >= 0 || j >= 0) {
            
            if(i < 0) {
                currA = 0;
                currB = b.charAt(j) - '0';
            } else if(j < 0) {
                currA = a.charAt(i) - '0';
                currB = 0;                
            } else {
                currA = a.charAt(i) - '0';
                currB = b.charAt(j) - '0';
            }
            
            currSum = currA + currB + carry;
            
            if(currSum == 0) {
                sb.append("0");
                carry = 0;
            } else if(currSum == 1) {
                sb.append("1");
                carry = 0;
            } else if(currSum == 2) {
                sb.append("0");
                carry = 1;
            } else {
                sb.append("1");
                carry = 1;
            }
            
            i--;
            j--;
        }
        
        if(carry != 0) {
            sb.append("1");
        }
        
        return sb.reverse().toString();
    }
    
    
}
