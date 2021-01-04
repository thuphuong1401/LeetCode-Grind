/*
https://leetcode.com/problems/range-sum-of-bst/
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
    int sum = 0;
    
    public int rangeSumBST(TreeNode root, int low, int high) {
        inOrder(root, low, high);
        return sum;
    }
    
    public void inOrder(TreeNode root, int low, int high) {
        if(root == null) {
            return; 
        }
        inOrder(root.left, low, high);
        if(low <= root.val && root.val <= high) {
            sum += root.val;
        }
        inOrder(root.right, low, high);
    }


// Optimized
class Solution {
    int sum = 0;
    
    public int rangeSumBST(TreeNode root, int low, int high) {
        inOrder(root, low, high);
        return sum;
    }
    
    public void inOrder(TreeNode root, int low, int high) {
        if(root == null) {
            return; 
        }
        if(low <= root.val && root.val <= high) {
            sum += root.val;
        }
        // Optimized 
        // Don't traverse into out-of-range branches 
        // Traverse left iff low < root.val. If low > root.val, all values to the left subtree of root are out of range.
        if(low < root.val) {
            inOrder(root.left, low, high);
        }
        if(high > root.val) {
            inOrder(root.right, low, high);
        }
    }
}
