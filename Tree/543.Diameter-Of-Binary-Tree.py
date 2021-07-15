# https://leetcode.com/problems/diameter-of-binary-tree/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        self.MAX = 0 
        self.maxPathLength(root)
        return self.MAX
    
    
    # return the max 'straight' path including current node. 
    # parent can utilize this path
    
    def maxPathLength(self, root: TreeNode) -> int:
        if root is None:
            return -1
        
        if root.left is None and root.right is None:
            return 0
        
        max_left_path_length = self.maxPathLength(root.left)
        max_right_path_length = self.maxPathLength(root.right)
        
        max_path_go_through_root = max_left_path_length + max_right_path_length + 2
        self.MAX = max(self.MAX, max_path_go_through_root)
        
        return max(max_left_path_length, max_right_path_length) + 1
        
