/*
https://leetcode.com/problems/first-missing-positive/
Big idea:
- n : length of array
- The first missing positive number lies in [1...N]. If not it's N+1
- We don't care about any numbers that lie out of range [1...N], i.e. all numbers <= 0.
*/
class Solution {

  int INF = (int) 1e9;

  public int firstMissingPositive(int[] nums) {
    int n = nums.length;

    // Mark all numbers <= 0 with INF since we don't care about them
    for (int i = 0; i < n; i++) {
      if (nums[i] <= 0 || nums[i] > n) {
        nums[i] = INF;
      }
    }

    // Use the number itself (if not out of array bound) to 'mark' its existence in the array
    for (int i = 0; i < n; i++) {
      int curr = Math.abs(nums[i]) - 1;
      if (curr >= 0 && curr < n && nums[curr] > 0) {
        nums[curr] *= (-1);
      }
    }

    // The first number >= 0 (i.e. its index in the array +1 is the first number in range [1...N] that does not exist in the array
    // is the FIRST MISSING POSITIVE
    for (int i = 0; i < n; i++) {
      if (nums[i] >= 0) {
        return i + 1;
      }
    }
    return n + 1;
  }
}
