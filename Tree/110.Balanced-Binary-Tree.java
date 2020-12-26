/*
https://leetcode.com/problems/balanced-binary-tree/
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

// Top-down recursion => redundant since one has to calculate height over and over again
class Solution {
    
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        
        if(Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        
        boolean x = isBalanced(root.left);
        boolean y = isBalanced(root.right);
        return x&y;
    
    }
    
    public int height(TreeNode root) {
        if(root == null) {
            return 0;
        }    
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}


