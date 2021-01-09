/*
https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxSum = root.val;
        int level = 1;
        int minLevel = 1;
        while(!queue.isEmpty()) {
            int currSum = 0;
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode top = queue.remove();
                currSum += top.val;
                if(top.left != null) {
                    queue.add(top.left);
                }
                if(top.right != null) {
                    queue.add(top.right);
                }
            }
            System.out.println(currSum);
            if(currSum > maxSum) {
                maxSum = currSum;
                minLevel = level;
            }
            level++;
        }
        return minLevel;
    }
}
