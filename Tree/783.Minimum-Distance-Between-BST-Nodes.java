/*
https://leetcode.com/problems/minimum-distance-between-bst-nodes/
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
    TreeNode prev;
    Integer min;
    
    public int minDiffInBST(TreeNode root) {
        prev = null;
        min = Integer.MAX_VALUE;
        inOrder(root);
        return min;
    }
    
    private void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        
        inOrder(root.left);
        if(prev != null) {
            min = Math.min(min, root.val - prev.val);
        }
        prev = root;
        
        inOrder(root.right);
    }
    
}
