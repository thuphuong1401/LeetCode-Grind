/*
https://leetcode.com/problems/majority-element/
*/

// HashMap, O(N) time, O(N) space
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            if(map.get(nums[i]) > nums.length / 2) {
                return nums[i];
            }
        }
        return -1;
    }
}


// Boyer-Moore voting algorithm
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for(int num : nums) {
            if(count == 0) {
                candidate = num;
            }
            if(num == candidate) {
                count += 1;
            } else {
                count += -1;
            }
        }
        return candidate;
    }
}
