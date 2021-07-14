# https://leetcode.com/problems/binary-tree-maximum-path-sum/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    def maxPathSum(self, root: TreeNode) -> int:
        self.MAX = -1001
        self.helper(root)
        return self.MAX
        
    # return length of longest 'straight' path
    def helper(self, root: TreeNode) -> int: 
        if root is None:
            return 0
        
        left_length = max(0, self.helper(root.left))
        right_length = max(0, self.helper(root.right))
        
        curr_max = root.val + left_length + right_length
        self.MAX = max(self.MAX, curr_max)
        
        curr_longest_path_left = root.val + left_length
        curr_longest_path_right = root.val + right_length
        
        return max(curr_longest_path_left, curr_longest_path_right) 
