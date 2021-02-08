/*
https://leetcode.com/problems/partition-labels/
*/


/*
My implementation
Big idea: using a greedy approach
- Store last position of every character present in the input string
- Loop through the input string, keep the max last position seen so far. If curr_index == max_last_position_seen, finishes a parition at that index.
Time O(n), Space O(1)
Note: I thought space here is supposed to be O(n) since I allocate a new Hash Map to keep the last count. However, the solution and multiple sources 
on LeetCode says that it should just be O(1) since there are at most 26 characters in the alphabet. Seems alright tho.

Why this approach works:
- Each letter is guaranteed to be in only 1 partition, since a new partition CANNOT START if we haven't reached the max last seen index of a character.
*/
class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastPos = new HashMap<>();
        int n = s.length();
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            lastPos.put(c, i);
        }
        
        List<Integer> partitionLengths = new ArrayList<>();
        
        int currPartitionLength = 0;
        int max = 0;
        
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            currPartitionLength++;
            int last = lastPos.get(c);
            max = Math.max(max, last);
            if(i == max) {
                partitionLengths.add(currPartitionLength);
                currPartitionLength = 0;
            }
        }
        
        
        return partitionLengths;
    }
}
