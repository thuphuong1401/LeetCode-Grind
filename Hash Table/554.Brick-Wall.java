/*
https://leetcode.com/problems/brick-wall/
*/
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int maxFreq = 0;
        for(List<Integer> layer : wall) {
            int sum = 0;
            for(int i = 0; i < layer.size(); i++) {
                sum += layer.get(i);
                if(map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                } else {
                    map.put(sum, 1);
                }
                
                if(map.get(sum) > maxFreq && i != layer.size() - 1) {
                    maxFreq = map.get(sum);
                }
                
            }
        }
        
        return wall.size() - maxFreq;
        
    }
}
