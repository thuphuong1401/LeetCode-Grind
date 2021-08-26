/*
https://leetcode.com/problems/meeting-rooms-ii/
*/

/*
Brute force O(n^2) solution: 
for interval in intervals:
  if(there exists room available to insert interval into):
    insert
  else:
    allocate new room
return size of list of rooms
*/
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        List<List<int[]>> allRooms = new ArrayList<>();
        allRooms.add(new ArrayList<>());
        allRooms.get(0).add(intervals[0]);
        for(int i = 1; i < n; i++) {
            int[] currInterval = intervals[i];
            boolean foundRoom = false;
            for(List<int[]> rooms : allRooms) {
                if(isAvailable(rooms, currInterval)) {
                    rooms.add(currInterval);
                    foundRoom = true;
                    break;
                }
            }
            if(!foundRoom) {
                allRooms.add(new ArrayList<>());
                allRooms.get(allRooms.size() - 1).add(currInterval);
            }
        }
        return allRooms.size();
    }
    
    
    
    private boolean isAvailable(List<int[]> rooms, int[] currInterval) {
        int n = rooms.size();
        if(rooms.get(n-1)[1] <= currInterval[0]) {
            return true;
        }
        for(int i = 0; i < n-1; i++) {
            if(currInterval[0] >= rooms.get(i)[1] && currInterval[1] <= rooms.get(i+1)[0]) {
                return true;
            }
        }
        return false;
    }
}


