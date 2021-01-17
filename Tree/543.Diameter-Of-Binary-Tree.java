/*
https://leetcode.com/problems/diameter-of-binary-tree/
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
class Solution {
    
    int max = 0;
    // Idea: diameter of the root = leftHeight + rightHeight
    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return max;
    }
    
    public int diameter(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int leftHeight = diameter(root.left);
        int rightHeight = diameter(root.right);
        
        max = Math.max(max, leftHeight + rightHeight);
        
        return Math.max(leftHeight, rightHeight) + 1;
        
    }
}
