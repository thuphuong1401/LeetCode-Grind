/*
https://leetcode.com/problems/permutations/
*/

class Solution {
    List<List<Integer>> answer;
    
    public List<List<Integer>> permute(int[] nums) {
        answer = new ArrayList<List<Integer>>();
        int n = nums.length;
        permute(nums, 0, n);
        return answer;
    }
    
    public void permute(int[] nums, int l, int r) {
        if(l == r) {
            answer.add(new ArrayList<Integer>(toArrayList(nums)));
        } else {
            for(int i = l; i < r; i++) {
                // swap l and i
                int temp = nums[l];
                nums[l] = nums[i];
                nums[i] = temp;
                
                // recursion
                permute(nums, l+1, r);
                
                // backtrack the swap
                int temp2 = nums[l];
                nums[l] = nums[i];
                nums[i] = temp2;
             }
        }
    }
    
    public List<Integer> toArrayList(int[] nums) {
        List<Integer> toReturn = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            toReturn.add(nums[i]);
        }
        return toReturn;
    }
    
}
