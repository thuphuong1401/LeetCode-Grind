# https://leetcode.com/problems/linked-list-cycle/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

'''
Floyd's Hare and Tortoise algorithm
There are a slow (moving 1 step at a time) and fast (moving 2 steps at a time) pointers. If there is a cycle,
the two pointers will eventually collide. If there isn't, fast pointer will either get to null or fast.next = null
'''
class Solution:
    def hasCycle(self, head: ListNode) -> bool:
        if head is None:
            return False
        
        slow = head
        fast = head
        
        while fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                return True
        
        return False
