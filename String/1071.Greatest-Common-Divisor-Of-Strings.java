/*
https://leetcode.com/problems/greatest-common-divisor-of-strings/
*/

/*
Brute force solution - try all prefixes of the shorter string
*/
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String shorter = "";
        String longer = "";
        if(str1.length() > str2.length()) {
            longer = str1;
            shorter = str2;
        } else {
            longer = str2;
            shorter = str1;
        }
        String largestDivisor = "";
        
        for(int i = 1; i <= shorter.length(); i++) {
            String curr = shorter.substring(0, i);
            StringBuilder sb1 = new StringBuilder(curr);
            StringBuilder sb2 = new StringBuilder(curr);
            
            while(sb1.length() < shorter.length()) {
                sb1.append(curr);
            }
            
            while(sb2.length() < longer.length()) {
                sb2.append(curr);
            }
            
            if(sb1.toString().equals(shorter) && sb2.toString().equals(longer)) {
                largestDivisor = curr;
            }
        }

        return largestDivisor;
    }
}



/*
Very smart recursion based solution
*/

