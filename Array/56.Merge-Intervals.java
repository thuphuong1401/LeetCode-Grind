/*
https://leetcode.com/problems/merge-intervals/
*/

/*
My implementation
Big idea:
- Sort the interval array so that smaller interval[0] comes first
- Make an arraylist. Add an interval to an array iff 1. list is empty, 2. start of an interval is greater than the end of the last interval in the array list
- merge happens if the end of the last interval in arraylist < end of interval (in consideration)
*/
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        
        for(int[] interval : intervals) {
            if(merged.size() == 0 || interval[0] > merged.get(merged.size() - 1)[1]) {
                merged.add(interval);
            } else {
                if(merged.get(merged.size() - 1)[1] < interval[1]) {
                    merged.get(merged.size() - 1)[1] = interval[1];
                }
            }
        }
        
        int[][] toReturn = new int[merged.size()][2];
        return merged.toArray(toReturn);
    }
}


class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        List<int[]> intervalList = new ArrayList<>();
        intervalList.add(intervals[0]);
        for(int i = 1; i < n; i++) {
            int[] curr = intervals[i];
            if(curr[0] > intervalList.get(intervalList.size() - 1)[1]) {
                intervalList.add(curr);
            } else if(curr[1] >= intervalList.get(intervalList.size() - 1)[1]) {
                intervalList.get(intervalList.size() - 1)[1] = curr[1];
            }
        }
        
        int size = intervalList.size();
        int[][] ans = new int[size][2];
        for(int i = 0; i < size; i++) {
            ans[i] = intervalList.get(i);
        }
        return ans;
    }
}
