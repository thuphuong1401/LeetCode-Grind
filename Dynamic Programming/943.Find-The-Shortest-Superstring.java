/*
https://leetcode.com/problems/find-the-shortest-superstring/

n : words.length
dp[][] = new String[2^n + 1][n + 1]

dp[mask][i] = min(dp[pMask][j] - overlap + words[i] for j=1 in pMask)
(dp[mask][i] = shortest superstring that contains words that are 1-bit in mask, 
and ending at words[i]

pMask = mask with ith bit turned off)


for(0<= mask <= 2^n):
    for (0 <= i <= n):
        pMask = turn ith bit of mask off
        for j = 1 in pMask:
            check overlap words[j], words[i] to see what is the largest
            dp[mask][i] = dp[pMask][largest_overlap] - overlap + words[i] 

return min(dp[mask][i] for i in n)

Ex: dp[111][0] = min(dp[011][1] or dp[011][2])
*/

class Solution {
    
    public String shortestSuperstring(String[] words) {
        int n = words.length;
        int max = 1 << n;
        String[][] dp = new String[max][n];
        
        for(int i = 0; i < max; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = "";
            }
        }
        
        for(int mask = 1; mask < max; mask++) {
            for(int i = 0; i < n; i++) {
                if(((mask >> i) & 1) == 0) { // ith bit not turned on in mask
                    continue;
                }
                int ithBitOff = ~(1 << i); // 1111...0....1111, 0 is the ith bit
                int pMask = mask & ithBitOff;
                if(pMask == 0) {
                    dp[mask][i] = words[i];
                    continue;
                }
                int tempPMask = pMask;
                int minAns = Integer.MAX_VALUE;
                int minIndex = 0;
                int j = 0;
                while(tempPMask != 0 && j <= n) {
                    int currBit = tempPMask & 1;
                    if(currBit == 1) {
                        int numOverlap = overlap(words[j], words[i]);
                        int l = dp[pMask][j].length() - numOverlap + words[i].length();
                        if(l < minAns) {
                            minAns = l;
                            minIndex = j;
                        }
                    }
                    j++;
                    tempPMask >>= 1;
                }
                
                dp[mask][i] = dp[pMask][minIndex].substring(0, minAns - words[i].length() ) + words[i];
            }
        }
        
        int shortest = Integer.MAX_VALUE;
        String ans = "";
        for(int i = 0; i < n; i++) {
            if(dp[max - 1][i].length() < shortest) {
                ans = dp[max - 1][i];
                shortest = dp[max - 1][i].length();
            }
        }
        return ans;
    }
    
    
    private int overlap(String word_i, String word_j) {
        int m = word_i.length();
        int n = word_j.length();
        int numOverlap = 0;
        for(int start = m-1; start >= 0; start--) { // point of start comparing in word_i
            int s = start;
            int i = 0;
            while(s < m && i < n) {
                char c_i = word_i.charAt(s);
                char c_j = word_j.charAt(i);
                if(c_i != c_j) {
                    break;
                }
                s++;
                i++;
            }
            if(s == m) {
                numOverlap = Math.max(numOverlap, i);
        
            }
        }
        return numOverlap;
    }
    
}



