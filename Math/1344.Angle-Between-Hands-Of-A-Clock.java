/*
https://leetcode.com/problems/angle-between-hands-of-a-clock/
*/

class Solution {
    public double angleClock(int hour, int minutes) {
        if(hour == 12) {
            hour = 0;
        }
        double r = minutes/60.0;
        double beta = r * 360.0;
        double alpha = hour * 30.0 + r * 30.0;
        double angle = Math.abs(beta - alpha);
        return Math.min(angle, 360.0 - angle);
    }
}
