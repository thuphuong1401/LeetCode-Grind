/*
https://leetcode.com/problems/delete-node-in-a-bst/
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
    public TreeNode deleteNode(TreeNode root, int key) {
        return delete(root, key);
    }
    
    private TreeNode delete(TreeNode root, int key) {
        if(root == null) {
            return root;
        }
        
        // locate the node to remove
        if(root.val > key) {
            root.left = delete(root.left, key);
        } else if(root.val < key) {
            root.right = delete(root.right, key);
        } else { // found it - 3 cases
            if(root.left == null) { // no left subtree => replace node to delete by root of right subtree
                return root.right;
            } else if(root.right == null) { // no right subtree => replace node to delete by root of left subtree
                return root.left;
            } else { // both left & right subtree exists
                TreeNode temp = minVal(root.right);
                root.val = temp.val;
                root.right = delete(root.right, temp.val);
            }
        }
        return root;
    }
        
    
    
    private TreeNode minVal(TreeNode root) {
        TreeNode temp = root;
        while(temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }
    
}




/*
Another solution that is just SLIGHTY different from the previous one
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
    public TreeNode deleteNode(TreeNode root, int key) {
        return delete(root, key);
    }
    
    private TreeNode delete(TreeNode root, int key) {
        if(root == null) {
            return root;
        }
        
        // locate the node to remove
        if(root.val > key) {
            root.left = delete(root.left, key);
        } else if(root.val < key) {
            root.right = delete(root.right, key);
        } else { // found it - 3 cases
            // The difference is here: I assign root = root.right and root = root.left then return root
            if(root.left == null) { // no left subtree => replace node to delete by root of right subtree
                root = root.right;
                return root;
            } else if(root.right == null) { // no right subtree => replace node to delete by root of left subtree
                root = root.left;
                return root;
            } else { // both left & right subtree exists
                TreeNode temp = minVal(root.right);
                root.val = temp.val;
                root.right = delete(root.right, temp.val);
            }
        }
        return root;
    }
        
    
    
    private TreeNode minVal(TreeNode root) {
        TreeNode temp = root;
        while(temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }
    
}
