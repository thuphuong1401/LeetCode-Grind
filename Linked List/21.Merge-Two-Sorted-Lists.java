/*
https://leetcode.com/problems/merge-two-sorted-lists/
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


// My implementation, so lengthy
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return l1;
        }
        
        if(l1 == null) {
            return l2;
        }
        
        if(l2 == null) {
            return l1;
        }
        
        ListNode toReturn = new ListNode();
        
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode currReturn = toReturn;
        
        
        while(curr1 != null && curr2 != null) {
            if(curr1.val <= curr2.val) {
                currReturn.val = curr1.val;
                curr1 = curr1.next;
                
            } else {
                currReturn.val = curr2.val;
                curr2 = curr2.next;
            }
            currReturn.next = new ListNode();
            currReturn = currReturn.next;
        }
        
        
        if(curr1 == null) {
            while(curr2 != null) {
                currReturn.val = curr2.val;
                curr2 = curr2.next;
                if(curr2 != null) {
                    currReturn.next = new ListNode();
                    currReturn = currReturn.next;
                }
            }
        }
        
        if(curr2 == null) {
            while(curr1 != null) {
                currReturn.val = curr1.val;
                curr1 = curr1.next;
                if(curr1 != null) {
                    currReturn.next = new ListNode();
                    currReturn = currReturn.next;
                }
            }
        }
        
        return toReturn;
    }
}



// Iterative way, much more optimized
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        
        if(l2 == null) {
            return l1;
        }
        
        ListNode head = new ListNode(0); // sentinel
        
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode temp = head;
        
        while(curr1 != null && curr2 != null) {
            if(curr1.val <= curr2.val) {
                temp.next = curr1;
                curr1 = curr1.next;
            } else {
                temp.next = curr2;
                curr2 = curr2.next;
            }
            temp = temp.next;
        }
        
        
        if(curr1 != null) {
            temp.next = curr1;
        }
        
        if(curr2 != null) {
            temp.next = curr2;
        }
        
        return head.next;
        
    }
}



// Recursive way
class Solution {
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        
        if(l2 == null) {
            return l1;
        }
        
        ListNode head;
        
        if(l1.val <= l2.val) {
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }
        
        return head;
        
    }
}
