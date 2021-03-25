/*
https://leetcode.com/problems/reverse-words-in-a-string/
*/

/*
My solution - Time O(N), Space O(N)
*/
class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] temp = s.split("\\s+");
        
        StringBuilder ans = new StringBuilder();
        for(int i = temp.length - 1; i >= 0; i--) {
            ans.append(temp[i]);
            if(i != 0) {
                ans.append(" ");
            }
        }
        return ans.toString();
    }
}

