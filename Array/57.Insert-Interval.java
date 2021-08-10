/*
https://leetcode.com/problems/insert-interval/
*/
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> notMerged = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            notMerged.add(intervals[i]);
        }
        notMerged.add(newInterval);
        Collections.sort(notMerged, (a, b) -> Integer.compare(a[0], b[0]));
        int[][] inte = new int[n][];
        inte = notMerged.toArray(inte);
        return merge(inte);
    }
    
    
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        int n = intervals.length;
        result.add(intervals[0]);
        
        for(int i = 1; i < n; i++) {
            int[] interval = intervals[i];
            if(interval[0] > result.get(result.size() - 1)[1]) {
                result.add(interval); // no merge
            } else {
                int[] newInterval = new int[2];
                newInterval[0] = result.get(result.size() - 1)[0];
                newInterval[1] = Math.max(interval[1], result.get(result.size() - 1)[1]);
                result.remove(result.get(result.size() -1));
                result.add(newInterval);
            }
        }
        
        int[][] res = new int[result.size()][];
        return result.toArray(res);
    }
}
