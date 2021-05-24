/*
https://leetcode.com/problems/lru-cache/
*/

// key: contained by both dll and map(key)
// value: contained in Pair of dll
class Pair {
    int value; // value of the put(int key, int value)
    Node node; // corresponding node in the dll whose value is key of the put(int key, int value)
    
    public Pair(int value, Node node) {
        this.value = value;
        this.node = node;
    }
}

class Node {
    Node prev;
    Node next;
    int key; 
    
    public Node() {
        this.prev = null;
        this.next = null;
        this.key = 0;
    }
    
    public Node(int key) {
        this.prev = null;
        this.next = null;
        this.key = key;
    }
}


class DoublyLinkedList {
    Node head;
    Node tail;
    
    public DoublyLinkedList() {
        this.head = new Node();
        this.tail = new Node();
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public void addToTail(int key) {
        Node newNode = new Node(key);
        Node prev = this.tail.prev;
        prev.next = newNode;
        newNode.prev = prev;
        newNode.next = this.tail;
        this.tail.prev = newNode;
    }
    
    public void delete(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    public Node end() {
        return this.tail;
    }
    
    public Node begin() {
        return this.head.next;
    }
    
}


class LRUCache {
    /*
    Key idea: 
    - dll contains node whose value is key
    - map contains <int, pair> where int is key and pair<int, node> where int is value and node is the corresponding node having that key in the dll
    - dll maintains order 
    - map helps quick look up
    - with every operation, make sure to modify both dll and hashmap
    */
    DoublyLinkedList dll; // head: least recently used; tail: most recently used
    Map<Integer, Pair> map;
    int capacity;
    
    public LRUCache(int capacity) {
        this.dll = new DoublyLinkedList();
        this.map = new HashMap<>();
        this.capacity = capacity;
    }
    
    // every operation: make (key, value) pair most recently used.
    public int get(int key) {
        if(this.map.containsKey(key)) {
            Pair found = this.map.get(key);
            this.dll.delete(found.node);
            this.dll.addToTail(key);
            this.map.get(key).node = this.dll.end().prev;
            return found.value;
        }   
        return -1;
    }
    
    public void put(int key, int value) {
        if(this.map.containsKey(key)) {
            Pair p = this.map.get(key);
            dll.delete(p.node);
        } else if(!this.map.containsKey(key) && this.map.size() == capacity) {
            map.remove(dll.begin().key);
            dll.delete(dll.begin());
            
        }
        dll.addToTail(key);
        map.put(key, new Pair(value, dll.end().prev));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
