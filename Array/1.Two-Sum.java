/*
https://leetcode.com/problems/two-sum/
See solution for more details of 3 approaches
*/

/*
Brute force solution - O(n^2)
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        for(int i = 0; i < nums.length-1; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    answer[0] = i;
                    answer[1] = j;
                }
            }    
        }
        return answer;
    }
}


/*
Two pass Hash Table
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        // Store <value, index> for O(1) index access given value
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++) {
            // Can't use an element more than once, hence the diff condition
            if(map.containsKey(target - nums[i]) && i != map.get(target - nums[i])) {
                answer[0] = i;
                answer[1] = map.get(target - nums[i]);
                break;
            }
        }
        return answer;
    }
}


/*
One pass Hash Table
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                answer[0] = i;
                answer[1] = map.get(target - nums[i]);
                break;
            }
            // No need to worry about duplicated elements
            map.put(nums[i], i);
        }
        return answer;
    }
}
