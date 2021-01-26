/*
https://leetcode.com/problems/add-two-numbers/
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode curr = result;
        ListNode currL1 = l1;
        ListNode currL2 = l2;
        
        
        int sum = 0, carry = 0, currDigit = 0, lastDigitL1 = 0, lastDigitL2 = 0;
        while(currL1 != null || currL2 != null) {
            if(currL1 == null) {
                lastDigitL1 = 0;
            } else {
                lastDigitL1 = currL1.val;
            }
            
            if(currL2 == null) {
                lastDigitL2 = 0;
            } else {
                lastDigitL2 = currL2.val;
            }
            
            sum = lastDigitL1 + lastDigitL2 + carry;
            currDigit = sum % 10;
            carry = sum / 10;
            
            curr.next = new ListNode(currDigit);
            curr = curr.next;
            
            if(currL1 != null) {
                currL1 = currL1.next;
            }
            
            if(currL2 != null) {
                currL2 = currL2.next;  
            } 
            
        }
        
        if(carry != 0) {
            curr.next = new ListNode(carry);
        }
        
        return result.next;
    }
    
    
    
}
