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

Big idea: 
- At every interval, choose any unoccupied room is OK => 2nd solution: instead of choosing randomly (by looping through array), we choose the room having the earliest end time.
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
        return false;
    }    
}




/*
2nd solution
*/
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        PriorityQueue<Integer> pq = new PriorityQueue();
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        int roomCount = 1;
        pq.add(intervals[0][1]);
        for(int i = 1; i < n; i++) {
            int[] currInterval = intervals[i];
            int start = currInterval[0];
            int end = currInterval[1];
            if(pq.peek() <= start) { // there is a room available for this interval
                pq.remove();
                pq.add(end);
            } else {
                pq.add(end);
                roomCount++;
            }
        }
        return roomCount;
    }
}






