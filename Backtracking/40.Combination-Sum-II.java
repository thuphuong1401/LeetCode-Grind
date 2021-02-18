/*
https://leetcode.com/problems/combination-sum-ii/
*/

class Solution {
    List<List<Integer>> answer;
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        answer = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(candidates, temp, target, 0);
        return answer;
    }
    
    private void backtracking(int[] candidates, List<Integer> temp, int target, int index ) {
        if(target == 0) {
            answer.add(new ArrayList<Integer>(temp));
            return;
        } else if(target < 0) {
            return;
        }
        
        for(int i = index; i < candidates.length; i++) {
            // important - handling duplicates here
            /*
            Tại vị trí i trong dãy temp: skip s
            */
            if(i > index && candidates[i-1] == candidates[i]) {
                continue;
            }
            temp.add(candidates[i]);
            backtracking(candidates, temp, target - candidates[i], i+1);
            
            temp.remove(temp.size() - 1);
        }
    }
    
}
