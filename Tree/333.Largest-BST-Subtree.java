/*
https://leetcode.com/problems/largest-bst-subtree/
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class InfoNode {
    int max; // max value in subtree rooted at node
    int min; // min value in subtree rooted at node
    boolean isBST; // is the subtree rooted at node a BST
    int currMaxSize; // the current maximum size of a BST in tree so far
    
    public InfoNode(int max, int min, boolean isBST, int currMaxSize) {
        this.max = max;
        this.min = min;
        this.isBST = isBST;
        this.currMaxSize = currMaxSize;
    }
}


class Solution {    
    public int largestBSTSubtree(TreeNode root) {
        InfoNode res = helper(root);
        return res.currMaxSize;
    }
    
    private InfoNode helper(TreeNode root) {
        if(root == null) {
            return new InfoNode(Integer.MIN_VALUE, Integer.MAX_VALUE, true, 0);
        }
        
        InfoNode leftInfo = helper(root.left);
        InfoNode rightInfo = helper(root.right);
        
        int maxSubtreeAtRoot = Math.max(root.val, Math.max(leftInfo.max, rightInfo.max));
        int minSubtreeAtRoot = Math.min(root.val, Math.min(leftInfo.min, rightInfo.min));
        
        if(leftInfo.isBST && rightInfo.isBST && leftInfo.max < root.val && root.val < rightInfo.min) { // potential for subtree rooted at root to become a BST
            
            int currMaxSizeAtRoot = leftInfo.currMaxSize + rightInfo.currMaxSize + 1;
            return new InfoNode(maxSubtreeAtRoot, minSubtreeAtRoot, true, currMaxSizeAtRoot);
            
        } else {
            
            int currMaxSizeAtRoot = Math.max(leftInfo.currMaxSize, rightInfo.currMaxSize);
            return new InfoNode(maxSubtreeAtRoot, minSubtreeAtRoot, false, currMaxSizeAtRoot);
        }
        
    }
    
}
