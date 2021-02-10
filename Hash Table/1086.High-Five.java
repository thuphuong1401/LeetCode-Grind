/*
https://leetcode.com/problems/high-five/
*/

/*
My implementation
Time O(n log n) (because of sorting), Space O(n) (allocation of hash map)
*/
class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer, List<Integer>> mapID = new HashMap<>();
        for(int[] item : items) {
            int id = item[0];
            int score = item[1];
            if(!mapID.containsKey(id)) {
                mapID.put(id, new ArrayList<>());
            }
            mapID.get(id).add(score);
        }
        
        for(int id : mapID.keySet()) {
            Collections.sort(mapID.get(id));
        }        
        
        System.out.println(mapID);
        
        Map<Integer, Integer> temp = new HashMap<>();
        for(int id : mapID.keySet()) {
            List<Integer> score = mapID.get(id);
            int sum = 0;
            for(int i = score.size() - 1; i >= score.size() - 5; i--) {
                sum += score.get(i);
                
            }
            sum /= 5;
            temp.put(id, sum);
        }
        
        int[][] ans = new int[mapID.size()][2];
        int i = 0;
        for(int id : temp.keySet()) {
            ans[i][0] = id;
            ans[i][1] = temp.get(id);
            i++;
        }
        
        Arrays.sort(ans, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                Integer temp1 = a[0];
                Integer temp2 = b[0];
                return temp1.compareTo(temp2);
            }    
        });
        
        return ans;
        
    }
}
