/*
https://leetcode.com/problems/binary-tree-paths/
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
    List<String> answer;
    
    public List<String> binaryTreePaths(TreeNode root) {
        answer = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        traverse(root, sb);
        return answer;
    }
    
    public void traverse(TreeNode root, StringBuilder sb) {
        if(root == null) {
            return;
        }        
        
        int length = sb.length();
        sb.append(root.val); // add node to string
        
        if(root.left == null && root.right == null) { // if a node is a leaf
            answer.add(sb.toString()); // add current string to answer list
        } else {
            sb.append("->");
            traverse(root.left, sb);
            traverse(root.right, sb);
        }
        sb.setLength(length); // backtrack
    }
    
}
