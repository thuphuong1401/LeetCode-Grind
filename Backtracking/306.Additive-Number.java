/*
https://leetcode.com/problems/additive-number/
*/
import java.math.BigInteger;

class Solution {
    
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        List<int[]> twoSeparators = new ArrayList<>();
        for(int i = 0; i < n-2; i++) {
            for(int j = i+1; j < n-1; j++) {
                twoSeparators.add(new int[]{i, j});
            }
        }
        
        for(int[] pos : twoSeparators) {
            String s1 = num.substring(0, pos[0] + 1);
            String s2 = num.substring(pos[0] + 1, pos[1] + 1);
            System.out.println(s1 + " " + s2);
            if(((!s1.equals("0") && s1.startsWith("0")) || (!s2.equals("0") && s2.startsWith("0")))) {
                continue;
            }
            String s3 = num.substring(pos[1] + 1, n);
            if(check(s1, s2, s3)) {
                return true;
            }
        }
        
        return false;
    }
    
    
    private boolean check(String s1, String s2, String s3) {
        if(s3.length() == 0) {
            return true;
        }
        BigInteger b1 = new BigInteger(s1);
        BigInteger b2 = new BigInteger(s2);
        BigInteger sum = b1.add(b2);
        String sumStr = sum.toString();
        if(s3.startsWith(sumStr)) {
            boolean ans = check(b2.toString(), sumStr, s3.substring(sumStr.length(), s3.length()));
            return ans;
        }
        return false;
    }
    
    
    
}
