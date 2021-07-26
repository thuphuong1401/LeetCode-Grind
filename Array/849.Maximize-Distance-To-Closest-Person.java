/*
https://leetcode.com/problems/maximize-distance-to-closest-person/
*/

class Solution {
    public int maxDistToClosest(int[] seats) {
        
        int MAX = (int)2e4+1;
        int n = seats.length;
        int[] closestPersonOnLeft = new int[n];
        int[] closestPersonOnRight = new int[n];
        
        int closestRight = MAX;
        for(int i = n-1; i >= 0; i--) {
            int currSeat = seats[i];
            if(currSeat == 1) {
                closestRight = 0;
            } else {
                closestRight++;
                closestPersonOnRight[i] = closestRight;
            }
        }
        
        
        int closestLeft = MAX;
        for(int i = 0; i < n; i++) {
            int currSeat = seats[i];
            if(currSeat == 1) {
                closestLeft = 0;
            } else {
                closestLeft++;
                closestPersonOnLeft[i] = closestLeft;
            }
        }
        
        int maxDist = -1;
        
        for(int i = 0; i < n; i++) {
            if(seats[i] == 1) {
                continue;
            }
            int minDistToOccupiedSeat = Math.min(closestPersonOnLeft[i], closestPersonOnRight[i]);
            maxDist = Math.max(maxDist, minDistToOccupiedSeat);
        }
        
        return maxDist;
    }
}
