/*
https://leetcode.com/problems/triangle/
*/
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> dp = null;
        int n = triangle.size();
        for(int i = n - 1; i >= 0; i--) {
            if(i == n-1) {
                dp = triangle.get(n-1);
                continue;
            }
            for(int j = 0; j < triangle.get(i).size(); j++) {
                dp.set(j, Math.min(dp.get(j), dp.get(j+1)) + triangle.get(i).get(j));             
            }
        }
        return dp.get(0);
    }
}
