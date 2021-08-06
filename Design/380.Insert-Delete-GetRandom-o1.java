/*
https://leetcode.com/problems/insert-delete-getrandom-o1/

Idea:
- Maintains a list of values and a hash map mapping value to its index in the list.
- Insert: insert in both map and list
- Delete: 
  + Delete from list: get index of val using map, swap that index with the end of the list, remove the end of the list, update new index of previous end of list in map
  + Delete from map
- GetRandom: randomize a number and get list(random number)
*/

class RandomizedSet {
    
    Map<Integer, Integer> valueToIndex;
    List<Integer> values;
    Random rand;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.valueToIndex = new HashMap<>();
        this.values = new ArrayList<>();
        this.rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(this.valueToIndex.containsKey(val)) {
            return false;
        }
        values.add(val);
        valueToIndex.put(val, values.size() - 1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(this.values.size() == 0 || !this.valueToIndex.containsKey(val)) {
            return false;
        }
        
        // let endIndex override val in values
        int index = this.valueToIndex.get(val);
        int endIndex = this.values.size() - 1;
        int endValue = this.values.get(endIndex);
        this.values.set(index, endValue);
        this.valueToIndex.put(endValue, index);
        
        
        // remove
        this.values.remove(endIndex);
        this.valueToIndex.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int r = this.rand.nextInt(this.values.size());
        return this.values.get(r);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
