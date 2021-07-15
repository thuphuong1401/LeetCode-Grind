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




/*
Calculuate max path sum for every single node in the tree
maxPathSum(root) = max(0, maxPathSum(root.left)) + max(0, maxPathSum(root.right)) + root.val
Don't know in what node will the maxPathSum happens => needs a global variable to track
Child node returns to parent the max 'straight' path involving that child node itself, 
i.e. max(maxPathSum(root.left) + root.val, maxPathSum(root.right) + root.val)
*/
class Solution {
    int globalMax = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        helper(root);
        return globalMax;
    }
    
    private int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        // max with 0 bc we don't have to include negative paths, which makes sum smaller
        int maxPathSumLeft = Math.max(0, helper(root.left));
        int maxPathSumRight = Math.max(0, helper(root.right));
        
        int currMaxPathSum = maxPathSumLeft + maxPathSumRight + root.val;
        globalMax = Math.max(globalMax, currMaxPathSum);
        
        return Math.max(maxPathSumLeft, maxPathSumRight) + root.val;
    }
}
