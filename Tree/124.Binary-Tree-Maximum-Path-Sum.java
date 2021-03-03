/*
https://leetcode.com/problems/binary-tree-maximum-path-sum/
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
    int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    
    private int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);
        max = Math.max(max, leftSum + rightSum + root.val);
        
        // at each node we want to return the longest path passing through this node. If the weight of a path is < 0, don't count it.
        // Since this value will be used by a node's parent, we can only pick the longest path out of either left or right subtree.
        return Math.max(0, root.val + Math.max(leftSum, rightSum)); 
    }
}
