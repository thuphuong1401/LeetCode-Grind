/*
https://leetcode.com/problems/longest-common-prefix/
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if(n == 0) {
            return "";
        }
        StringBuilder ans = new StringBuilder();
        String s = strs[0];
        boolean flag = true;
        for(int i = 0; i < s.length(); i++) {
            for(int j = 1; j < n; j++) {
                if(i >= strs[j].length()) {
                    flag = false;
                    break;
                }
                if(strs[j].charAt(i) != s.charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if(!flag) {
                break;
            }
            ans.append(s.charAt(i));
        }
        return ans.toString();
    }
}
