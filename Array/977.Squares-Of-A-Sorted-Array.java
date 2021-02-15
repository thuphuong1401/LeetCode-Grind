/*
https://leetcode.com/problems/squares-of-a-sorted-array/
*/

/*
Time O(n), Space O(1)
Idea: like two sum using 2 pointers. Have low = 0 and high = n-1. Assign value in answer array from index n-1 to 0 based on what square is greater, nums[low]^2 or nums[high]^2.
*/
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int i = n-1;
        int low = 0;
        int high = n-1;
        
        while(low <= high) {
            int lowSquared = nums[low] * nums[low];
            int highSquared = nums[high] * nums[high];
            if(lowSquared <= highSquared) {
                answer[i] = highSquared;
                high--;
            } else {
                answer[i] = lowSquared;
                low++;
            }
            i--;
        }
        return answer;
    }
}
