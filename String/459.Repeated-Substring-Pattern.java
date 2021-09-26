/*
https://leetcode.com/problems/repeated-substring-pattern/
*/
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        /*
        Observation: use rotation of s (for eg: "helloworld" -> "worldhello")
        Every rotation of s is a substring of s + s
        */
        String temp = s + s;
        int n = temp.length();
        temp = temp.substring(1, n-1);
        int start = temp.indexOf(s);
        if(start == -1) {
            return false;
        }
        return true;
    }
}
