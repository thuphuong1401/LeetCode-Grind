/*
https://leetcode.com/problems/boundary-of-binary-tree/
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
    List<Integer> allNodes;
    
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        allNodes = new ArrayList<>();
        if(root == null) {
            return allNodes;
        }
        if(root.left == null && root.right == null) {
            allNodes.add(root.val);
            return allNodes;
        }
        allNodes.add(root.val);
        leftBoundary(root.left);
        leaves(root);
        rightBoundary(root.right);
        return allNodes;
    }
    
    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
    
    private void leftBoundary(TreeNode root) {
        if(root == null || isLeaf(root)) {
            return;
        }
        
        allNodes.add(root.val);
        
        if(root.left != null) {
            leftBoundary(root.left);
        } else {
            leftBoundary(root.right);
        }
    }
    
    private void leaves(TreeNode root) {
        if(root == null) {
            return;
        }
        
        if(isLeaf(root)) {
            allNodes.add(root.val);
        }
        
        leaves(root.left);
        leaves(root.right);
    }
    
    
    private void rightBoundary(TreeNode root) {
        if(root == null || isLeaf(root)) {
            return;
        }
        
        if(root.right != null) {
            rightBoundary(root.right);
        } else {
            rightBoundary(root.left);
        }
        
        allNodes.add(root.val);
    }
    
}
