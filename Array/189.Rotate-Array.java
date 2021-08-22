/*
https://leetcode.com/problems/rotate-array/
Big idea:
- Reverse whole array
- Reverse array from 0 to k-1
- Reverse array from k-1 to n-1
*/

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n; 
        
        for(int i = 0; i < n/2; i++) {
            int temp = nums[i];
            nums[i] = nums[n-1-i];
            nums[n-1-i] = temp;
        }
        
        for(int i = 0; i < k/2; i++) {
            int temp = nums[i];
            nums[i] = nums[k-1-i];
            nums[k-1-i] = temp;
        }
        
        for(int i = 0; i < (n-k)/2; i++) {
            int temp = nums[k + i];
            nums[k + i] = nums[n-1-i];
            nums[n-1-i] = temp;
        }
        
    }
}


/*
Memory access on adjacent elements => this solution is slightly faster than the first one
*/
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
        
    }
    
    
    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    
}
