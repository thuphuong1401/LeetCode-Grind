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


/* 3 pointers 
Time O(n), Space O(1)
*/
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



// Not my solution
class Solution {
    public int thirdMax(int[] nums) {
        Integer first = nums[0];
        Integer second = null;
        Integer third = null;
        
        for(int i = 1; i < nums.length; i++) {
            Integer curr = nums[i];
            
            // if duplicate, continue
            if(curr.equals(first) || curr.equals(second) || curr.equals(third)) {
                continue;
            }
            
            if(first == null || first < curr) {
                third = second;
                second = first; 
                first = curr;
            } else if(second == null || second < curr) {
                third = second;
                second = curr;
            } else if(third == null || third < curr) {
                third = curr;
            }
        }
        
        if(third != null) {
            return third;
        }
        return first;
    }
}
