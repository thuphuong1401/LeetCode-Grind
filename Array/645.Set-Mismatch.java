/*
https://leetcode.com/problems/set-mismatch/
NOTE: there is a XOR solution, O(n) time, O(1) space, however it's really tricky
*/


/*
My implementation, time O(n), space O(n)
*/
class Solution {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int[] answer = new int[2];
        int n = nums.length;
        for(int i : nums) {
            if(set.contains(i)) {
                answer[0] = i;
                break;
            }
            set.add(i);
        }
        
        set.clear();
        
        for(int i : nums) {
            set.add(i);
        }
        
        for(int i = 1; i <= n; i++) {
            if(!set.contains(i)) {
                answer[1] = i;
                break;
            }    
        } 
        
        return answer;
    }
}


/*
Idea:
- Mark all nums[nums[i]] = -nums[nums[i]] to see what numbers appear in the array
- Numbers marked negative twice => repeated. 
- Only positive number => not appearing in the array

The only catch when doing problems like this is that it's easy yet you have to be careful
*/
class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] answer = new int[2];
        int n = nums.length;
        
        for(int i = 0; i < n; i++) {
            int curr = Math.abs(nums[i]);
            if(nums[curr - 1] < 0) {
                answer[0] = curr;
                continue; // have to have this, be careful. Why? Because you want to mark nums[nums[i]] to be a negative number just once.
            }
            nums[curr - 1] = -nums[curr - 1];
        }
        
        for(int i = 0; i < n; i++) {
            if(nums[i] > 0) {
                answer[1] = i+1;
                break;
            }
        }
        
        return answer;
        
    }
}


