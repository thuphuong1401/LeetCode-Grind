/*
https://leetcode.com/problems/sum-of-left-leaves/
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
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if(root == null) {
            return sum;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode top = queue.remove();
                if(top.left != null) {
                    queue.add(top.left);
                    if(top.left.left == null && top.left.right == null) {
                        sum += top.left.val;
                    }
                } 
                if(top.right != null) {
                    queue.add(top.right);
                }
            }
        }
        return sum;
    }
}
