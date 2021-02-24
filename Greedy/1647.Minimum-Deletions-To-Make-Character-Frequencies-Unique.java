/*
https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
*/
class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        Arrays.sort(freq);
        int max = freq[25];
        int res = 0;
        for(int i = 25; i >= 0; i--) {
            if(freq[i] == 0) {
                break;
            }
            if(freq[i] > max) {
                res += (freq[i] - max);
            } else {
                max = freq[i];
            }
            if(max > 0) {
                max--;
            }
        }
        return res;
    }
}
