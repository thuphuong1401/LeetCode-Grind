# https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class InfoNode: 
    def __init__(self, max, min, isBST, currMaxSum):
        self.max = max # max value in subtree rooted at node
        self.min = min # min value in subtree rooted at node
        self.isBST = isBST # is subtree rooted at node a BST?
        self.currMaxSum = currMaxSum # current sum of BST rooted at node
    
    
class Solution:
    def maxSumBST(self, root: TreeNode) -> int:
        self.ans = 0
        root_info = self.helper(root)
        return self.ans
    
    def helper(self, root: TreeNode) -> InfoNode:
        if root is None:
            return InfoNode(-40001, 40000, True, 0)
        
        left_info = self.helper(root.left)
        right_info = self.helper(root.right)
        
        curr_max = max(root.val, max(left_info.max, right_info.max))
        curr_min = min(root.val, min(left_info.min, right_info.min))
        curr_max_sum_left =  left_info.currMaxSum
        curr_max_sum_right = right_info.currMaxSum
        
        if left_info.isBST and right_info.isBST and left_info.max < root.val and root.val < right_info.min:
            currMaxSum = curr_max_sum_left + root.val + curr_max_sum_right
            self.ans = max(self.ans, currMaxSum)
            return InfoNode(curr_max, curr_min, True, currMaxSum)
        else: # current subtree rooted at root is not a BST, hence no need to update currMaxSum
            return InfoNode(curr_max, curr_min, False, -1)
