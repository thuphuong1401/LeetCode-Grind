# https://leetcode.com/problems/linked-list-cycle-ii/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    
    def detectCycle(self, head: ListNode) -> ListNode:
        if head == None:
            return None
        
        slow = head
        fast = head
        containsCycle = False
        while fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                containsCycle = True
                break
        
        if not containsCycle:
            return None
        
        start = head
        while start != slow:
            start = start.next
            slow = slow.next
            
        return start
