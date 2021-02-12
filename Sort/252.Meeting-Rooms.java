/*
https://leetcode.com/problems/meeting-rooms/
*/

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int n = intervals.length;
        for(int i = 0; i < n-1; i++) {
            if(intervals[i][1] > intervals[i+1][0]) {
                return false;
            }
        }
        
        return true;
        
    }
}
