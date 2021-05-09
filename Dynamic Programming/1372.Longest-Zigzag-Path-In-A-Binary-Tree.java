/*
https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/
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
    public int longestZigZag(TreeNode root) {
        return Math.max(longestPath(root, 0, -1), longestPath(root, 1, -1));        
    }
    
    private int longestPath(TreeNode root, int direction, int currPathLength) {
        if(root == null) {
            return currPathLength;
        }
        
        // di theo dung direction. Neu di theo khac direction => reset length = 0
        
        int res = 0;
        if(direction == 0) {
            // longestPath(root.right, 0, 0) NOT longestPath(root.right, 0, -1) bc we already know that root != null
            // => minLength is at least 0
            res = Math.max(longestPath(root.left, 1, currPathLength + 1), longestPath(root.right, 0, 0));
        } else {
            // ditto
            res = Math.max(longestPath(root.right, 0, currPathLength + 1), longestPath(root.left, 1, 0));
        }
        
        return res;
    }
    
}
