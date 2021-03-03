/*
https://leetcode.com/problems/copy-list-with-random-pointer/
*/

/*
My implementation - O(n) time, O(n) space using 3 hashmaps
*/
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> randomMap = new HashMap<>(); // <old node, random of such old node>
        Map<Node, Node> oldToNew = new HashMap<>(); // <old node, corresponding new copy of such old node>
        Map<Node, Node> newToOld = new HashMap<>(); // <new node, corresponding old version of such new copy>
        
        Node newHead = new Node(0);
        Node pointer = head;
        Node newPointer = newHead;
        
        // Have to copy the whole linkedlist with next pointers first
        while(pointer != null) {
            newPointer.next = new Node(pointer.val);
            randomMap.put(pointer, pointer.random); // old to old
            oldToNew.put(pointer, newPointer.next);
            newToOld.put(newPointer.next, pointer);
            pointer = pointer.next;
            newPointer = newPointer.next;
        }
        
        newPointer = newHead.next;
        
        // populate random pointers
        while(newPointer != null) {
            Node oldCorrespondingPointer = newToOld.get(newPointer);
            Node oldRandom = randomMap.get(oldCorrespondingPointer);
            Node newRandom = oldToNew.get(oldRandom);
            newPointer.random = newRandom;
            newPointer = newPointer.next;
        }
        
        return newHead.next;
    }
}



/*
Very smart O(n) time, O(1) space solution by interweaving old and new copy of a node in the original linked list
*/
class Solution {
    public Node copyRandomList(Node head) {
        Node temp = head;
        while(temp != null) {
            Node copy = new Node(temp.val);
            Node next = temp.next;
            temp.next = copy;
            copy.next = next;
            temp = temp.next.next;
        }
        
        temp = head;
        while(temp != null) {
            Node rand = temp.random;
            if(rand == null) {
                temp.next.random = null;
            } else {
                temp.next.random = rand.next;
            }
            if(temp.next != null) {
                temp = temp.next.next;
            }
        }
        
        temp = head;
        Node newHead = new Node(0);
        Node copy = newHead;
        Node copyIter = newHead;
        
        while(temp != null) {
            Node next = temp.next.next;
            
            // extract the copy
            copy = temp.next;
            copyIter.next = copy;
            copyIter = copy;
            
            // restore the original list
            temp.next = next;
            temp = next;
        }
        
        return newHead.next;
    }
}
