/*
https://leetcode.com/problems/reverse-linked-list/
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
 
// Easy iterative
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;
        while(temp != null) {
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
}


// Recursive
