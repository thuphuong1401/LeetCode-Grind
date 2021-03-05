/*
https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if(root == null) {
            return answer;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> levelList = new LinkedList<>();
            for(int i = 0; i < size; i++) {
                TreeNode top = queue.remove();
                if(level % 2 == 0) {
                    levelList.addLast(top.val);
                } else {
                    levelList.addFirst(top.val);
                }
                
                if(top.left != null) {
                    queue.add(top.left);
                }
                
                if(top.right != null) {
                    queue.add(top.right);
                }
            }
            level++;
            answer.add(levelList);
        }
        return answer;
    }
}
