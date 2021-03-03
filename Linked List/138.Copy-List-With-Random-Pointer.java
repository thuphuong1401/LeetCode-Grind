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
        
        // create interweaving list
        while(temp != null) {
            Node currCopy = new Node(temp.val);
            Node next = temp.next;
            temp.next = currCopy;
            currCopy.next = next;
            temp = temp.next.next;
        }
        
        // modify random pointers
        temp = head;
        while(temp != null) {
            Node tempRandom = temp.random;
            if(tempRandom == null) {
                temp.next.random = null;
            } else {
                temp.next.random = tempRandom.next;
            }
            temp = temp.next.next;
        }
        
        // separate new linked list from interweaved, restore the first one
        temp = head;
        Node newHead = new Node(0);
        Node newTemp = newHead;
        while(temp != null) {
            Node tempNext = temp.next;
            Node tempNextNext = temp.next.next;
            
            newTemp.next = tempNext;
            newTemp = newTemp.next;
            
            temp.next = tempNextNext;
            temp = temp.next;
            
        }
        
        return newHead.next;
    }
}
