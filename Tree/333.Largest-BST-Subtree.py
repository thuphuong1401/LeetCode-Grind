# https://leetcode.com/problems/largest-bst-subtree/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

MAX = 10001
MIN = -10001

class NodeInfo:
    
    def __init__(self, max, min, isBST, currMaxSize):
        self.max = max  # max value in subtree 
        self.min = min  # min value in subtree
        self.isBST = isBST # whether subtree is a BST
        self.currMaxSize = currMaxSize  # size of current max BST (from root downwards, isn't necessarily rooted at current node. In other words, somewhere in the subtree rooted at root, there happens to be a maximum size BST (so far))
        
        
class Solution:
    def largestBSTSubtree(self, root: TreeNode) -> int:
        node_info = self.helper(root)
        return node_info.currMaxSize
    
    def helper(self, root: TreeNode) -> NodeInfo:
        if root is None:
            return NodeInfo(MIN, MAX, True, 0)
        
        info_left = self.helper(root.left)
        info_right = self.helper(root.right)
        
        currMax = max(root.val, max(info_left.max, info_right.max))
        currMin = min(root.val, min(info_left.min, info_right.min))
        
        if info_left.isBST and info_right.isBST and info_left.max < root.val and root.val < info_right.min:
            currMaxSize = info_left.currMaxSize + info_right.currMaxSize + 1
            return NodeInfo(currMax, currMin, True, currMaxSize)
        else:
            currMaxSize = max(info_left.currMaxSize, info_right.currMaxSize)
            return NodeInfo(currMax, currMin, False, currMaxSize)
        
        
