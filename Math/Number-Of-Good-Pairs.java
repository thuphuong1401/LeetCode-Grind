/*
https://leetcode.com/problems/number-of-good-pairs/
*/

// Naive approach: O(n^2) => double for loop, increment the count of good pairs for every arr[i] == arr[j]

/*
Efficient approach below:
1. For each number in nums, obtains its count
2. Calculate numbers of pairs formed by an unique number. It's n(n-1)/2
*/
class Solution {
    public int numIdenticalPairs(int[] nums) {
        int n = nums.length;
        int goodPairs = 0;
        int[] unique = new int[101];
        for(int x : nums) {
            unique[x]++;
        }
        for(int i = 0; i < 101; i++) { 
            int l = unique[i];
            goodPairs += (l * (l-1))/2;
        }
        return goodPairs;
    }
}
