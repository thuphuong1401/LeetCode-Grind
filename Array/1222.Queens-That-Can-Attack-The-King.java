/*
https://leetcode.com/problems/queens-that-can-attack-the-king/
*/

class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for(int[] pos : queens) {
            String s = Integer.toString(pos[0]) + " " + Integer.toString(pos[1]);
            set.add(s);
        }
        for(int i = -1; i <= 1; i++) {
            for(int j = -1; j <= 1; j++) {
                for(int k = 0; k <= 8; k++) {
                    int x = king[0] + i * k;
                    int y = king[1] + j * k;
                    String temp = Integer.toString(x) + " " + Integer.toString(y);
                    if(set.contains(temp)) {
                        ans.add(new ArrayList<>());
                        ans.get(ans.size() - 1).add(x);
                        ans.get(ans.size() - 1).add(y);
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
