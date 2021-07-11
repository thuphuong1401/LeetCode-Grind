# https://leetcode.com/problems/binary-tree-preorder-traversal/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        result = []
        node: TreeNode = root
        
        while node is not None:
            if node.left is None:
                result.append(node.val)
                node = node.right
            else:
                predecessor = node.left # node cuoi cung bi duyet trong left subtree of node        
                
                while predecessor.right is not None and predecessor.right is not node:
                    predecessor = predecessor.right
                
                if predecessor.right is None: # day la lan dau duyet qua node 
                    result.append(node.val)
                    predecessor.right = node
                    node = node.left
                else:
                    predecessor.right = None
                    node = node.right
                    
        
        return result
