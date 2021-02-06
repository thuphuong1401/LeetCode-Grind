/*
https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
*/

/*
My solution: 
- For every nums[i], let nums[i] - 1 be its marking index. Mark nums[index] = -nums[index] => we haved marked all the numbers that appears in the array
- Loop through the array again. Positive nums[i] means that it was not 'marked' and hence (i+1) is missing from the array
*/
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int curr = Math.abs(nums[i]);
            if(nums[curr - 1] < 0) {
                continue; 
            } else {
                nums[curr-1] = -nums[curr-1];
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(nums[i] > 0) {
                answer.add(i+1);
            }
        }
           
        return answer;
    }
}
