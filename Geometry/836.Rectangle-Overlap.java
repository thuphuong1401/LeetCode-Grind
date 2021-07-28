/*
https://leetcode.com/problems/rectangle-overlap/
Idea: find the width (lesser of the right edges and greater of the left edges) and height of the overlapping part. If both > 0 => overlap
*/
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int rec1_x1 = rec1[0];
        int rec1_y1 = rec1[1];
        int rec1_x2 = rec1[2];
        int rec1_y2 = rec1[3];
        
        int rec2_x1 = rec2[0];
        int rec2_y1 = rec2[1];
        int rec2_x2 = rec2[2];
        int rec2_y2 = rec2[3];
        
        int width = Math.min(rec1_x2, rec2_x2) - Math.max(rec1_x1, rec2_x1);
        int height = Math.min(rec1_y2, rec2_y2) - Math.max(rec1_y1, rec2_y1);
        
        return (width > 0) && (height > 0);
    }
}
