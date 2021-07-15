# https://leetcode.com/problems/diameter-of-binary-tree/

# All the following solutions are O(N) time and O(N) space (due to implicit recursion stack)
# Most important general idea to remember:
# find diameter = for all nodes, find max path length (from a leaf of left subtree to a leaf of right subtree) passing through a node 
# = use recursion to find max path length passing through node.left and node.right, then max path length passing through node = 
# max path length (root.left) + max path length(root.right) (+2 or not depends on the base case: root is None). Child node returns 
# to its parents the max of EITHER max path length (root.left) OR max path length (root.right) + 1 (because parents may utilize this information)

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
        
        
        
        
# Another version of the same solution, just slightly modified one condition in the maxPathLength function
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
        
        max_left_path_length = self.maxPathLength(root.left)
        max_right_path_length = self.maxPathLength(root.right)
        
        max_path_go_through_root = max_left_path_length + max_right_path_length + 2
        self.MAX = max(self.MAX, max_path_go_through_root)
        
        return max(max_left_path_length, max_right_path_length) + 1
        
        
        
# Yet another version of the same solution. The if root is None condition is changed
class Solution:
    
    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        self.MAX = 0 
        self.maxPathLength(root)
        return self.MAX
    
    
    # return the max 'straight' path including current node. 
    # parent can utilize this path
    
    def maxPathLength(self, root: TreeNode) -> int:
        if root is None:
            return 0
        
        max_left_path_length = self.maxPathLength(root.left)
        max_right_path_length = self.maxPathLength(root.right)
        
        max_path_go_through_root = max_left_path_length + max_right_path_length 
        self.MAX = max(self.MAX, max_path_go_through_root)
        
        return max(max_left_path_length, max_right_path_length) + 1
        
