/*
https://leetcode.com/problems/combinations/
*/

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = i+1;
        }
        int[] permute = new int[k];
        permutation(nums, permute, res, 0, 0, k);
        return res;
        
    }
    
    public void permutation(int[] nums, int[] permute, List<List<Integer>> res, int i, int p, int k) {
        if(i == k) {
            res.add(toArrayList(permute));
            return;
        }
        
        for(int j = p; j < nums.length; j++) {
            permute[i] = nums[j];
            permutation(nums, permute, res, i+1, j+1, k);
        }
    }
    
    public List<Integer> toArrayList(int[] nums) {
        List<Integer> toArrList = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            toArrList.add(nums[i]);
        }
        return toArrList;
    }
    
}
