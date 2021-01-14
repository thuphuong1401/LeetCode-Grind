/*
Frequent problem, met in OA Goldman Sachs
https://leetcode.com/problems/height-checker/
*/
class Solution {
    public int heightChecker(int[] heights) {
        List<Integer> copy = new ArrayList<>();
        for(int i = 0; i < heights.length; i++) {
            copy.add(heights[i]);
        }
        Collections.sort(copy);
        int count = 0;
        for(int i = 0; i < heights.length; i++) {
            if(heights[i] != copy.get(i)) {
                count++;
            }
        }
        return count;
        
    }
}
