/*
https://leetcode.com/problems/design-hashset/
*/

class MyHashSet {
    LinkedList<Integer>[] set;
    final int size = 2999;
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        this.set = new LinkedList[size];
        for(int i = 0; i < size; i++) {
            this.set[i] = new LinkedList<Integer>();
        }
    }
    
    public int hash(int key) {
        return key % size;
    }
    
    public void add(int key) {
        int hashed = hash(key);
        if(contains(key)) {
            return;
        }
        this.set[hashed].add(key);
    }
    
    public void remove(int key) {
        int hashed = hash(key);
        if(this.set[hashed].contains(key)) {
            this.set[hashed].remove((Integer)key);    // dit me cai type control cua Java
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hashed = hash(key);
        int index = this.set[hashed].indexOf(key);
        return index != -1;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
