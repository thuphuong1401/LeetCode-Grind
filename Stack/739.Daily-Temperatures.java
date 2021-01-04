/*
https://leetcode.com/problems/daily-temperatures/
*/

// Brute force method
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int n  = T.length;
        int[] answer = new int[n];
        for(int i = 0; i < n-1; i++) {
            for(int j = i+1; j < n; j++) {
                if(T[j] > T[i]) {
                    answer[i] = j-i;
                    break;
                }
            }
        }
        return answer;
    }
}


// Stack
