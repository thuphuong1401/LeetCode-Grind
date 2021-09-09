/*
https://leetcode.com/problems/swap-nodes-in-pairs/
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode curr = head;
        
        ListNode sentinel = new ListNode(-1);
        ListNode newPointer = sentinel;
        
        while(curr != null && curr.next != null) {
            ListNode first = curr;
            ListNode second = curr.next;
            ListNode nextIter = curr.next.next;
            
            first.next = null;
            second.next = null;
            
            newPointer.next = second;
            newPointer = newPointer.next;
            newPointer.next = first;
            newPointer = newPointer.next;
            
            curr = nextIter;
        }
        
        if(curr != null) {
            newPointer.next = curr;
        }
        
        return sentinel.next;
    }
}



