/*
https://leetcode.com/problems/binary-tree-right-side-view/
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> right = new ArrayList<>();
        if(root == null) {
            return right;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode top = queue.remove();
                if(i == size-1) {
                    right.add(top.val);
                }
                if(top.left != null) {
                    queue.add(top.left);
                }
                if(top.right != null) {
                    queue.add(top.right);
                }
            }
        }
        return right;
    }
}
