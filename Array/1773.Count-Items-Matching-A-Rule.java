/*
https://leetcode.com/problems/count-items-matching-a-rule/
*/

class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count =  0;
        int rule = 0;
        if(ruleKey.equals("color")) {
            rule = 1;
        } else if(ruleKey.equals("name")) {
            rule = 2;
        }
        
        for(List<String> list : items) {
            if(list.get(rule).equals(ruleValue)) {
                count++;
            }
         }
        return count;
    }
}
