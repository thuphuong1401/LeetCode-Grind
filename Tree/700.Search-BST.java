/*
https://leetcode.com/problems/search-in-a-binary-search-tree/
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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) {
            return null;
        }
        if(root.val > val) {
            return searchBST(root.left, val);
        } else if(root.val < val) {
            return searchBST(root.right, val);
        } 
        return root;
    }
}



// Iterative
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode temp = root;
        while(temp != null && val != temp.val) {
            if(temp.val < val) {
                temp = temp.right;
            } else {
                temp = temp.left;
            }
        }
        return temp;
    }
}
