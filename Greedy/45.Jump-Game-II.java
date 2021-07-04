/*
https://leetcode.com/problems/jump-game-ii/
*/
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int currMax = 0;
        int currLevel = 0;
        for(int i = 0; i < n-1; i++) {
            currMax = Math.max(currMax, i + nums[i]);
            if(i == currLevel) {
                ans++;
                currLevel = currMax;
            }
        }
        return ans;
    }
}


/*
Think of this problem as a BFS level order traversal problem
start: begin of current level, end: end of current level
Positions are on the same 'level' iff they are reachable from the start using the same number of steps (i.e. number of levels)
*/
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int numJumps = 0;
        int currStart = 0, currEnd = 0, nextStart = 0, nextEnd = 0;
        
        while(currEnd < n-1) {
            nextStart = currEnd + 1;
            for(int i = currStart; i <= currEnd; i++) { // find where next level ends
                nextEnd = Math.max(nextEnd, i + nums[i]);
            }
            numJumps++;   
            currStart = nextStart;
            currEnd = nextEnd;
        }
        return numJumps;
    }
}
