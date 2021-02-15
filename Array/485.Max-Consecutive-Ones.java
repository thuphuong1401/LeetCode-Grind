/*
https://leetcode.com/problems/max-consecutive-ones/
*/

/*
My implementation, a bit lengthy
Time O(n), Space O(1)
*/
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int currCount = 0, maxCount = 0;
        if(nums[0] == 1) {
            currCount = 1;
            maxCount = 1;
        }
        
        for(int i = 1; i < nums.length; i++) {
            if(nums[i-1] == 1 && nums[i] == nums[i-1]) {
                currCount++;
            } else if(nums[i] == 1) {
                currCount = 1;
            } else {
                currCount = 0;
            }
            maxCount = Math.max(maxCount, currCount);
        }
        return maxCount;
    }
}


/*
A slightly shorter solution
*/
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int currCount = 0;
        int maxCount = 0;
        for(int i : nums) {
            if(i == 1) {
                currCount += 1;
                maxCount = Math.max(currCount, maxCount);
            } else {
                maxCount = Math.max(currCount, maxCount);
                currCount = 0;
            }
        }
        return maxCount;
    }
}
