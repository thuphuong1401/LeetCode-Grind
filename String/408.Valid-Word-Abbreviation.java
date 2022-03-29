/*
https://leetcode.com/problems/valid-word-abbreviation/
*/
class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;
        int n = word.length();
        int m = abbr.length();
        while(i < n && j < m) {
            if(word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
            } else {
                if(abbr.charAt(j) <= '0' || abbr.charAt(j) > '9') {
                    return false;
                }
                int start = j;
                while(j < m && '0' <= abbr.charAt(j) && abbr.charAt(j) <= '9') {
                    j++;
                }
                int num = Integer.parseInt(abbr.substring(start, j));
                i += num;
            }
        }
        return (i == n && j == m);
    }
}
