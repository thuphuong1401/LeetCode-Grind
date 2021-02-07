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
