/*
https://leetcode.com/problems/remove-duplicates-from-sorted-list/
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
 
 
/*
My implementation: Time O(n), Space O(n) since we need to allocate new space for the hashset. 
*/
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null) {
            if(!set.contains(curr.val)) {
                set.add(curr.val);
                prev = curr;
                curr = curr.next;
            } else {
                ListNode next = curr.next;
                prev.next = next;
                curr.next = null;
                curr = next;
            }
        }
        return head;
    }
}


/*
The solution's implementation - Just delete the next node of the current node if curr.next.val == curr.val
*/
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
