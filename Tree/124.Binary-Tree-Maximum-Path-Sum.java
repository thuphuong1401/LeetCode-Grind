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
        
        return Math.max(0, root.val + Math.max(leftSum, rightSum)); // crucial
    }
}
