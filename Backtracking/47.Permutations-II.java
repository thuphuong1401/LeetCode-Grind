/*
https://leetcode.com/problems/permutations-ii/
*/

class Solution {
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        int n = nums.length;
        answer = permute(nums, 0, n, answer);
        return answer;
    }
    
    public List<List<Integer>> permute(int[] nums, int l, int r, List<List<Integer>> answer) {
        if(l >= r) {
            answer.add(arrayToList(nums));
        } else {
            
            for(int i = l; i < r; i++) {
                if(shouldSwap(nums, l, i)) {
                    // swap nums[l] with nums[i]
                    int temp = nums[l];
                    nums[l] = nums[i];
                    nums[i] = temp;

                    permute(nums, l+1, r, answer);

                    // backtrack
                    int temp2 = nums[l];
                    nums[l] = nums[i];
                    nums[i] = temp2;
                }
            }
        }    
        
        return answer;
    }
    
    public boolean shouldSwap(int[] nums, int index, int ind) {
        for(int i = index; i < ind; i++) {
            if(nums[i] == nums[ind]) {
                return false;
            }
        }
        return true;
    }
    
    public List<Integer> arrayToList(int[] arr) {
        List<Integer> toReturn = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            toReturn.add(arr[i]);
        }
        return toReturn;
    }
    
    
}
