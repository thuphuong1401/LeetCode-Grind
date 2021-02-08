/*
https://leetcode.com/problems/two-sum-iii-data-structure-design/
*/

/*
Big idea:
- Keep a hashmap, count <num, frequency>
- For every find operation: 
  + Loop through the map, need to find whether value - key exists
  + If map contains value - key:
  If value - key = key, have to check whether frequency of key is > 1
  Else, return true
*/
class TwoSum {
    
    Map<Integer, Integer> map;

    /** Initialize your data structure here. */
    public TwoSum() {
        this.map = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
        }
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(int key : map.keySet()) {
            int diff = value - key;
            if(map.containsKey(diff)) {
                if(diff == key) {
                    if(map.get(diff) > 1) {
                        return true;
                    }    
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
