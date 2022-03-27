/*
https://leetcode.com/problems/maximum-number-of-consecutive-values-you-can-make/
*/

class Solution {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int n = coins.length;
        // Every number in [0, miss) is formable by coins[0...i] 
        int miss = 1; // smallest number NOT formable by coins so far
        int i = 0;
        for(int coin : coins) {
            if(coin <= miss) { // can add coins[i] to [0, miss) to form new range [0, miss + coin)
                miss += coin;
            } else {
                break;
            }
        }
        return miss;
    }
}

