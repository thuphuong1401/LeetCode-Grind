/*
https://leetcode.com/problems/find-all-duplicates-in-an-array/
*/


// O(n) time, O(n) space
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> appearTwice = new ArrayList<>();
        for(int i : nums) {
            if(set.contains(i)) {
                appearTwice.add(i);
            } else {
                set.add(i);
            }
        }
        return appearTwice;
    }
}


// O(n) time, O(1) space, so smart!
/*
Idea: 
- Since 1 <= a_i <= n, therefore each element value - 1 is a valid index
- Loop through the array. Mark arr[i-1] to be negative. If arr[i-1] has already been set to negative, we know that this element is repeated.
*/
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int curr = Math.abs(nums[i]);
            if(nums[curr - 1] < 0) {
                answer.add(Math.abs(nums[i]));
            }   
            nums[curr - 1] = -nums[curr-1];
        }
        
        return answer;
        
    }
}
