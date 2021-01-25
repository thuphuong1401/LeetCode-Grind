/*
https://leetcode.com/problems/find-all-duplicates-in-an-array/
*/


// O(n) time, O(n) space
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> appearTwice = new ArrayList<>();
        for(int i : nums) {
            if(set.contains(i)) {
                appearTwice.add(i);
            } else {
                set.add(i);
            }
        }
        return appearTwice;
    }
}


// O(n) time, O(1) space, so smart!

