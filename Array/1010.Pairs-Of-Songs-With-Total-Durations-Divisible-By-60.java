/*
https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
*/

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] mod = new int[60];
        for(int t : time) {
            mod[t % 60]++;
        }
        int count = 0;
        for(int i = 1; i < 30; i++) {
            count += (mod[i] * mod[60 - i]);
        }
        count += (mod[0] * (mod[0] - 1))/2;
        count += (mod[30] * (mod[30] - 1))/2;
        return count;
    }
}
