/*
https://leetcode.com/problems/combination-sum-iii/
*/

/*
Time: O(P(9, K)) * O(K) = O(9!*K / (9-K)!)
- O(K) since each correct 'solution' takes O(K) times to build and O(K) time to make a new deep copy
- Worst case => have to try all P(9, K) combination
Space: O(K) (because of extra currList and does not account for the space used to store the solution)
Space to store solution: O(P(9, K)).
*/
class Solution {
    List<List<Integer>> answer;
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        answer = new ArrayList<List<Integer>>();
        backtracking(k, n, 1, new ArrayList<Integer>());
        return answer;    
    }
    
    private void backtracking(int k, int n, int index, List<Integer> currList) {
        if(currList.size() == k && n == 0) {
            answer.add(new ArrayList<Integer>(currList));
            return;
        } else if(currList.size() == k || n < 0) {
            return;
        }
        
        for(int i = index; i <= 9; i++) {
            currList.add(i);
            n -= i;
            backtracking(k, n, i+1, currList);
            n += i;
            currList.remove(currList.size() - 1);
        }   
    }   
}
