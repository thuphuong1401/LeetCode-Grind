/*
https://leetcode.com/problems/subsets-ii/
*/

class Solution {
    List<List<Integer>> subsets;
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        subsets = new ArrayList<>();
        Arrays.sort(nums);
        for(int size = 0; size <= nums.length; size++) {
            backtrack(nums, 0, size, new ArrayList<>());
        }
        return subsets;
    }
    
    
    private void backtrack(int[] nums, int index, int size, List<Integer> temp) {
        if(temp.size() == size) {
            subsets.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = index; i < nums.length; i++) {
            if(i > index && nums[i] == nums[i-1]) {
                continue;
            }
            temp.add(nums[i]);
            backtrack(nums, i+1, size, temp);
            temp.remove(temp.size() - 1);
        }
    }
    
}
