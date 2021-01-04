/*
https://leetcode.com/problems/design-hashmap/
*/


// My implementation
class MyHashMap {
    int[] arr;

    /** Initialize your data structure here. */
    public MyHashMap() {
        arr = new int[1000001];
        Arrays.fill(arr, -1);
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        arr[key] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return arr[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        arr[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
 
 
 /*
 Idea: have an array of buckets, each bucket is a linkedlist
 */
 class Pair {
    int key;
    int value;
    
    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class Bucket {
    List<Pair> list;
    
    public Bucket() {
        this.list = new LinkedList<Pair>();
        this.list.add(new Pair(-1, -1));
    }
    
    
    public int get(int key) {
        for(Pair p : this.list) {
            if(p.key == key) {
                return p.value;
            }
        }
        return -1;
    }
    
    
    public void update(int key, int value) {
        for(Pair p : this.list) {
            if(p.key == key) {
                p.value = value;
                return;
            } 
        }
        this.list.add(new Pair(key, value));
    }
    
    
    public void remove(int key) {
        for(Pair p : this.list) {
            if(p.key == key) {
                this.list.remove(p);
                return;
            }
        }
    }
    
}

class MyHashMap {
    static final int numBuckets = 2999;
    Bucket[] buckets;

    /** Initialize your data structure here. */
    public MyHashMap() {
        this.buckets = new Bucket[numBuckets];
        for(int i = 0; i < 2999; i++) {
            this.buckets[i] = new Bucket();
        }
    }
    
    public int hash(int key) {
        return key % numBuckets;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hashed = hash(key);
        this.buckets[hashed].update(key, value);
    }
    
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hashed = hash(key);
        return this.buckets[hashed].get(key);
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hashed = hash(key);
        this.buckets[hashed].remove(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
