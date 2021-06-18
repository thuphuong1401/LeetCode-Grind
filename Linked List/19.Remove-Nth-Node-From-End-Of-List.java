/*
https://leetcode.com/problems/remove-nth-node-from-end-of-list/
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p1 = dummy; // pointer starts at nth, ends at tail
        ListNode p2 = dummy; // pointer starts at head, ends at nth
        int counter = 1;
        while(counter <= n) {
            p1 = p1.next;
            counter++;
        }
        while(p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        ListNode next = p2.next; 
        p2.next = next.next;
        
        return dummy.next;
        
    }
}


/*
Another version, my implementation
*/
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p1 = dummy; // pointer starts at nth, ends at tail
        ListNode p2 = dummy; // pointer starts at head, ends at nth
        int counter = 1;
        while(counter <= n) {
            p1 = p1.next;
            counter++;
        }
        boolean deleteHead = true;
        while(p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
            deleteHead = false;
        }
        if(deleteHead) {
            return head.next;
        }
        ListNode next = p2.next; 
        p2.next = next.next;
        
        return head;
        
    }
}
