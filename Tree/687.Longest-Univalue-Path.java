/*
https://leetcode.com/problems/longest-univalue-path/
Related problems: Maximum Path Sum, Diameter of Binary Tree
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

/*
My solution, time O(N), space O(N) (recursion stack)
*/
class Solution {
    int longest;
    
    public int longestUnivaluePath(TreeNode root) {
        longest = 0;
        helper(root);
        if(longest > 0) {
            return longest - 1; // number of edges, not nodes
        } else {
            return 0;
        }
    }
    
    private int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int longestLeft = helper(root.left);
        int longestRight = helper(root.right);
        
        TreeNode leftChild = root.left;
        TreeNode rightChild = root.right;
        
        int currLongest;
        
        if(leftChild != null && leftChild.val == root.val && rightChild != null && rightChild.val == root.val) { // can extend path to include current node and path from left and right subtree
            currLongest = longestLeft + longestRight + 1;
            longest = Math.max(longest, currLongest);
            return Math.max(longestLeft, longestRight) + 1; // return a 'straight' path to its parent node
        } else if(leftChild != null && leftChild.val == root.val) { // only path on the left subtree is extendable
            currLongest = 1 + longestLeft;
            longest = Math.max(longest, currLongest);
        } else if(rightChild != null && rightChild.val == root.val) { // only path on the right subtree is extendable
            currLongest = 1 + longestRight;
            longest = Math.max(longest, currLongest);
        } else {
            currLongest = 1;
            longest = Math.max(longest, currLongest);
        } 
        
        return currLongest;
    }
    
}
