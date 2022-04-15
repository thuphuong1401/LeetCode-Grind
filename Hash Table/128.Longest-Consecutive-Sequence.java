/*
https://leetcode.com/problems/longest-consecutive-sequence/

HashSet/Map and intelligent sequence building
*/

class Solution {
    /*
    Idea:
    - Put all numbers into a set
    - If num - 1 is in the set, num is not the start of a consecutive sequence, hence just move on.
    - Else, num might be the start of a consecutive sequence. In this case, examine whether num + 1, num + 2, num + 3, ... are in the set or not and update maxConsecutive count accordingly.
    */
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        int maxConsecutive = 0;
        for(int num : nums) {
            int currConsecutive = 1;
            if(set.contains(num - 1)) {
                continue;
            } else {
                int next = num + 1;
                while(set.contains(next)) {
                    currConsecutive++;
                    next++;
                }
                maxConsecutive = Math.max(maxConsecutive, currConsecutive);
            }
        }
        
        return maxConsecutive;
    }
}
