/*
https://leetcode.com/problems/binary-tree-postorder-traversal/
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
// Recursive
class Solution {
    
    List<Integer> listNode;
    
    // Recursive
    public List<Integer> postorderTraversal(TreeNode root) {
        listNode = new ArrayList<>();
        postOrder(root);
        return listNode;
    }
    
    public void postOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        
        postOrder(root.left);
        postOrder(root.right);
        listNode.add(root.val);
    }    
}


// Iterative
