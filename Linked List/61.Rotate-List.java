
/*
https://leetcode.com/problems/rotate-list/
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) {
            return head;
        }
        
        int n = 1;
        ListNode tail = head;
        while(tail.next != null) {
            n++;
            tail = tail.next;
        }
        
        tail.next = head;
        
        int counter = 0;
        ListNode prev = head;
        ListNode curr = head;
        k %= n;
        while(counter < n - k) {
            counter++;
            prev = curr;
            curr = curr.next;
        }
        
        prev.next = null;
        
        return curr;
        
        
        /*
        Rotate steps:
        - find length
        - find kth node from end. that kth node will be new head
        - end of linkedlist point to current head
        - prev kth points to null
        
        */
    }
}
