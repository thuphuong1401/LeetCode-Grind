/*
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
Big idea: 
- Utilize the fact that input array is sorted
- Have 2 pointers, first pointer at index 0, second pointer at index nums.length - 1. Get sum = nums[low] + nums[high]
  + If sum == target => return
  + If sum < target => have to decrement the sum by high-- 
  + If sum > target => have to increment the sum by low++
*/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        int[] index = new int[2];
        while(low < high) {
            int sum = numbers[low] + numbers[high];
            if(sum == target) {
                index[0] = low+1;
                index[1] = high+1;
                break;
            } else if(sum > target) {
                high--;
            } else {
                low++;
            }
        }
        return index;
    }
}
