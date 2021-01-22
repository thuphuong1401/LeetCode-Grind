/*
https://leetcode.com/problems/subsets/
*/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        for(int i = 0; i <= nums.length; i++) {
            int[] res = new int[i];
            answer = permutation(nums, res, answer, 0, 0, i);
        }
        return answer;
    }
    
    
    public List<List<Integer>> permutation(int[] nums, int[] res, List<List<Integer>> answer, int i, int p, int k) {
        if(i == k) {
            System.out.println(arrayToList(res));
            answer.add(arrayToList(res));
            return answer;
        } 
        else {
            for(int j = p; j < nums.length; j++) {
                res[i] = nums[j];
                permutation(nums, res, answer, i+1, j+1, k);
            }
        }
        return answer;
    }
    
    
    public List<Integer> arrayToList(int[] arr) {
        List<Integer> toReturn = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            toReturn.add(arr[i]);
        }
        return toReturn;
    }
}
