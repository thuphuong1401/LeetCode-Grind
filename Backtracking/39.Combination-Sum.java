/*
https://leetcode.com/problems/combination-sum/
Time complexity: check solution
Space complexity: check solution
*/

/*
My implementation
*/
class Solution {
    List<List<Integer>> answer;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        answer = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        backtracking(candidates, target, new ArrayList<Integer>(), 0, 0);
        return answer;
    }
    
    
    private void backtracking(int[] candidates, int target, List<Integer> currList, int currSum, int index) {
        if(currSum == target) {
            answer.add(new ArrayList<Integer>(currList));
            return;
        } else if(currSum > target || index == candidates.length) {
            return;
        }
        
        for(int i = index; i < candidates.length; i++) {
            currSum += candidates[i];
            currList.add(candidates[i]);
            backtracking(candidates, target, currList, currSum, i);
            currSum -= candidates[i];
            currList.remove(currList.size() - 1);
            
        }
    }
}


