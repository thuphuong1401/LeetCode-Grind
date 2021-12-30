/*
https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together/
*/

class Solution {
    public int minSwaps(int[] data) {
        int n = data.length;
        int numZeroes = 0;
        for(int num : data) {
            if(num == 0) {
                numZeroes++;
            }
        }
        
        int numOnes = n - numZeroes;
        
        if(numOnes == 1) {
            return 0;
        }
        
        int start = 0;
        int end = 0;
        int currNumZeroes = 0;
        int minNumZeroes = 1000000;
        
        while(end < numOnes) {
            if(data[end] == 0) {
                currNumZeroes++;
            }
            end++;
        }
        
        end--;
        
        minNumZeroes = Math.min(minNumZeroes, currNumZeroes);
        
        while(start <= end && end < n - 1) {    
            end++;
            start++;
            
            if(data[start - 1] == 0) {
                currNumZeroes--;
            }
            
            if(data[end] == 0) {
                currNumZeroes++;
            }
            
            minNumZeroes = Math.min(minNumZeroes, currNumZeroes);
        }
        
        return minNumZeroes;
    }
}
