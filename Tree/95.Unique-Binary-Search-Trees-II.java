/*
https://leetcode.com/problems/unique-binary-search-trees-ii/
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
    
    public List<TreeNode> generateTrees(int n) {
        return genTree(1, n);
    }
    
    
    private List<TreeNode> genTree(int left, int right) {
        List<TreeNode> allTrees = new ArrayList<>();
        if(left > right) {
            allTrees.add(null);
            return allTrees;
        }
        if(left == right) {
            TreeNode root = new TreeNode(left);
            allTrees.add(root);
            return allTrees;
        }
        for(int rootVal = left; rootVal <= right; rootVal++) {
            List<TreeNode> leftTrees = genTree(left, rootVal - 1);
            List<TreeNode> rightTrees = genTree(rootVal + 1, right);
            
            for(TreeNode leftNode : leftTrees) {
                for(TreeNode rightNode : rightTrees) {
                    TreeNode newRoot = new TreeNode(rootVal);
                    newRoot.left = leftNode;
                    newRoot.right = rightNode;
                    allTrees.add(newRoot);
                }
            }
        }
        return allTrees;
    }
    
    
}
