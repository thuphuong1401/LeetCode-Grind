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


// Much faster in terms of memory usage, and less complicated looking code
class Solution {
    List<List<Integer>> answer;
    int n, k; // n choose k problem
    
    public List<List<Integer>> subsets(int[] nums) {
        answer = new ArrayList<>();
        n = nums.length;
        List<Integer> res = new ArrayList<>();
        for(k = 0; k <= n; k++) {
            permute(nums, res, 0);
        }
        return answer;
    }
    
    
    public void permute(int[] nums, List<Integer> res, int p) {
        if(res.size() == k) {
            answer.add(new ArrayList<Integer>(res));
            return;
        }
        
        for(int j = p; j < n; j++) {
            res.add(nums[j]);
            permute(nums, res, j+1);
            res.remove(res.size() - 1);
        }
    }
    
}
