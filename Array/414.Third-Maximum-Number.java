/*
https://leetcode.com/problems/third-maximum-number/
*/


/*
Time O(n), Space O(n).
Idea:
- Put all element of nums[] into a hash set in order to filter out duplicates
- Use Collections.max to find max in hashset
- Remove max
*/
class Solution {
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            set.add(i);
        }
        int firstMax = Collections.max(set);
        if(set.size() < 3) {
            return firstMax;
        }
        
        set.remove(firstMax);
        int secondMax = Collections.max(set);
        set.remove(secondMax);
        int thirdMax = Collections.max(set);
        return thirdMax;
    }
}


// 3 pointers
class Solution {
    public int thirdMax(int[] nums) {
        Integer firstMax = nums[0];
        Integer secondMax = null;
        Integer thirdMax = null;
        
        for(int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            
            if(curr > firstMax) {
                if(secondMax != null) {
                    thirdMax = secondMax;
                } 
                secondMax = firstMax;
                firstMax = curr;
            } else if(curr < firstMax) {
                if(secondMax == null) {
                    secondMax = curr;
                } else {
                    if(curr > secondMax) {
                        thirdMax = secondMax;
                        secondMax = curr;
                    } else if(curr < secondMax) {
                        if(thirdMax == null) {
                            thirdMax = curr;
                        } else if(curr > thirdMax) {
                            thirdMax = curr;
                        }
                    }
                }
            }
            
        }
        
        if(thirdMax == null) {
            return firstMax;
        }
        
        return thirdMax;
    }
}


