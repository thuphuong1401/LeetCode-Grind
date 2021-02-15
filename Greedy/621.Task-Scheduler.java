/*
https://leetcode.com/problems/task-scheduler/
*/

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int m = tasks.length;
        int numberOfMaxFreqTask = 0;
        int maxFreqCount = 0;
        int[] count = new int[26];
        
        for(char task : tasks) {
            int currTask = task - 'A';
            count[currTask]++;
            
            if(count[currTask] > maxFreqCount) {
                maxFreqCount = count[currTask];
                numberOfMaxFreqTask = 1;
            } else if(count[currTask] == maxFreqCount) {
                numberOfMaxFreqTask++;
            }
            
        }
        
        
        int numPart = maxFreqCount - 1;
        int idleSlotPerPart = n - numberOfMaxFreqTask + 1;
        int totalIdleSlots = numPart * idleSlotPerPart;
        int taskNotFilled = m - numberOfMaxFreqTask * maxFreqCount;
        int idleSlotsLeft = Math.max(0, totalIdleSlots - taskNotFilled);
        return m + idleSlotsLeft;
        
        
    }
}
