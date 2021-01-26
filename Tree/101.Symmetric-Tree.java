/*
https://leetcode.com/problems/symmetric-tree/
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
Iterative
Do BFS on tree. Poll 2 nodes at a time, and the tree is symmetric iff the value of these 2 nodes are equal.
Queue up in order: t1.left, t2.right, t1.right, t2.left.

*/
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        
        while(!queue.isEmpty()) {
            TreeNode t1 = queue.remove();
            TreeNode t2 = queue.remove();
            
            if(t1 == null && t2 == null) {
                continue;
            }
            
            if(t1 == null || t2 == null) {
                return false;
            }
            
            if(t1.val != t2.val) {
                return false;
            }
            
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
        
        return true;
    }
}


/*
Recursive
Idea same as above
*/
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSym(root, root);
    }
    
    public boolean isSym(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) {
            return true;
        }
        if(t1 == null || t2 == null) {
            return false;
        }
        if(t1.val != t2.val) {
            return false;
        }
        return isSym(t1.left, t2.right) & isSym(t1.right, t2.left);
        
    }
}

