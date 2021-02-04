/*
https://leetcode.com/problems/middle-of-the-linked-list/
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
1st approach: 
- Count number of nodes
- Get middle node index
- Get middle node reference
*/
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode temp = head;
        int nodeCount = 0;
        while(temp != null) {
            temp = temp.next;
            nodeCount++;
        }
        int mid = (int) Math.ceil(nodeCount/2);
        int count = 0;
        
        ListNode temp2 = head;
        while(count != mid) {
            temp2 = temp2.next;
            count++;
        }
        return temp2;
    }
}


/*
2nd approach: fast pointer and slow pointer
- Fast pointer travels twice as fast as slow pointer
- If fast pointer reaches the end of the array, then slow pointer travels to the middle.
*/
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
}
