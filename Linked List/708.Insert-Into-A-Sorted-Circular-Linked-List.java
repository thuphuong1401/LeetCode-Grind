/*
https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        Node newNode = new Node(insertVal);
        if(head == null) {
            newNode.next = newNode;
            return newNode;
        }
        
        Node prev = head;
        Node curr = head.next;
        boolean inserted = false;
        
        /*
        3 cases can happen:
        - Node can be inserted in the middle of the list (min < insertVal < max)
        - Node > max or < min
        - All values of list nodes are the same
        */
        while(true) {
            
            if(prev.val <= insertVal && insertVal <= curr.val || prev.val > curr.val && insertVal > prev.val || prev.val > curr.val && insertVal < curr.val) {
                inserted = true;
                prev.next = newNode;
                newNode.next = curr;
                break;
            }
            
            prev = curr;
            curr = curr.next;
            
            if(prev == head) {
                break;   
            }
        }
        
        
        if(!inserted) {
            prev.next = newNode;
            newNode.next = curr;
        }
        
        
        return head;
    }
}
