# https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time O(N), space O(N) due to recursion stack
class Solution:
    
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.preorder(root)
        
        
    def preorder(self, root: TreeNode) -> TreeNode:
        
        if root is None:
            return None
        
        if root.left is None and root.right is None:
            return root 
        
        if root.left is None and root.right is not None:
            return self.preorder(root.right)
        
        
        left_root = root.left
        right_root = root.right
        root.right = left_root
        root.left = None
        
        last_node_leftsubtree = self.preorder(left_root)
        last_node_leftsubtree.right = right_root
        
        if right_root is None:
            return last_node_leftsubtree
        
        # last_node_rightsubtree 
        return self.preorder(right_root)
      
      
      
# Morris traversal method
class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        
        node = root
        while node is not None:
            if node.left is None:
                
                node = node.right
            else:
                predecessor = node.left
                while predecessor.right is not None and predecessor.right is not node:
                    predecessor = predecessor.right
                    
                if predecessor.right is None:
                    predecessor.right = node
                    node = node.left
                else: # node is magic door leading to right subtree
                    right_node = node.right
                    node.right = node.left
                    node.left = None
                    predecessor.right = right_node
                    node = right_node
                    
