/*
https://leetcode.com/problems/binary-tree-inorder-traversal/
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
 
// Note: inorder traversal == depth first search on tree
// Recursive implementation 
class Solution {    
    List<Integer> result = new ArrayList<>();
    
    public List<Integer> inorderTraversal(TreeNode root) {   
        inOrder(root);
        return result;
    }
    
    public void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        result.add(root.val);
        inOrder(root.right);
        
    }
}

// Iterative with a stack
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            answer.add(curr.val);
            curr = curr.right;
        }
        return answer;
    }
}

// Morris Traversal



