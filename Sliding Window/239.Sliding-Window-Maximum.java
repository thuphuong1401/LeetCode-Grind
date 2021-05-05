/*
https://leetcode.com/problems/sliding-window-maximum/
Big idea:
1. Maintain a monotonically DECREASING queue
2. Queue contains INDEX of elements in nums
3. Remove all elements which are out of the current window's range at the beginning of an iteration
4. Process the first window separately from other windows
*/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n == 1) {
            return new int[]{nums[0]};
        }
        
        int[] ans = new int[n-k+1];
        
        // maintain a monotonically decreasing deque
        Deque<Integer> deque = new ArrayDeque<>();
        int j = 0;
        for(int i = 0; i < n; i++) {
            while(!deque.isEmpty() && deque.peekFirst() <= i-k) {
                deque.pollFirst();
            }    
            
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            deque.addLast(i);
            if(i - k + 1 >= 0) {
                ans[j] = nums[deque.peekFirst()];
                j++;
            }
        }
        
        return ans;
    }
}
