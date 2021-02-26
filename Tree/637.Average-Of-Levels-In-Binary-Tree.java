/*
https://leetcode.com/problems/average-of-levels-in-binary-tree/
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
My implementation - BFS
*/
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Double> answer = new ArrayList<>();
        while(!queue.isEmpty()) {
            int size = queue.size();
            long levelSum = 0;
            for(int i = 0; i < size; i++) {
                TreeNode top = queue.remove();
                levelSum += top.val;
                if(top.left != null) {
                    queue.add(top.left);
                }
                
                if(top.right != null) {
                    queue.add(top.right);
                }
            }
            answer.add((double)(levelSum / (double) size));
        }
        return answer;
    }
}


/*
DFS
*/



