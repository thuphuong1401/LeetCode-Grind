/*
https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
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
    
    List<List<Integer>> levels = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) {
            return levels;
        }
        helper(root, 0);
        Collections.reverse(levels);
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
