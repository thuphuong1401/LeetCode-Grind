/*
https://leetcode.com/problems/print-immutable-linked-list-in-reverse/
*/


/**
 * // This is the ImmutableListNode's API interface.
 * // You should not implement it, or speculate about its implementation.
 * interface ImmutableListNode {
 *     public void printValue(); // print the value of this node.
 *     public ImmutableListNode getNext(); // return the next node.
 * };
 */

class Solution {
    public void printLinkedListInReverse(ImmutableListNode head) {
        List<ImmutableListNode> nodeValues = new ArrayList<>();
        while(head != null) {
            nodeValues.add(head);
            head = head.getNext();
        }
        for(int i = nodeValues.size() - 1; i >= 0; i--) {
            nodeValues.get(i).printValue();
        }
    }
}
