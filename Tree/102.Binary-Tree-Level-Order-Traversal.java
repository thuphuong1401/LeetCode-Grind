/*
https://leetcode.com/problems/binary-tree-level-order-traversal/
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
 
 
// Recursive method
class Solution {
    List<List<Integer>> levels = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return levels;
        }    
        helper(root, 0);
        return levels;
    }
    
    public void helper(TreeNode node, int level) {
        if(levels.size() == level) {
            levels.add(new ArrayList<Integer>());
        }
        levels.get(level).add(node.val);
        if(node.left != null) {
            helper(node.left, level + 1);
        }
        if(node.right != null) {
            helper(node.right, level + 1);
        }
    }
}

// My implementation - BFS based
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        if(root == null) {
            return answer;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> arr = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode top = queue.remove();
                arr.add(top.val);
                if(top.left != null) {
                    queue.add(top.left);
                }
                if(top.right != null) {
                    queue.add(top.right);
                }
            }
            answer.add(arr);
        }
        return answer;       
    }
}


