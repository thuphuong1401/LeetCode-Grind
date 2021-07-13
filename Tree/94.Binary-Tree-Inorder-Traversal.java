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
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> listNodes = new ArrayList<>();
        TreeNode node = root;
        while(node != null) {
            if(node.left == null) {
                listNodes.add(node.val);
                node = node.right;
            } else {
                TreeNode predecessor = node.left;
                while(predecessor.right != null && predecessor.right != node) {
                    predecessor = predecessor.right;
                }
                if(predecessor.right == null) {
                    predecessor.right = node;
                    node = node.left;
                } else {
                    
                    listNodes.add(node.val);
                    predecessor.right = null;
                    node = node.right;
                }
            }
            
        }
        
        return listNodes;
    }
}

// Another iterative approach using stack
class Solution {
    // left root right
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        stack.push(node);
        
        while(!stack.isEmpty()) {
            TreeNode currTop = stack.pop();
            if(currTop == null) {
                continue;
            }
            if(!stack.isEmpty() && stack.peek() == currTop.right) {
                result.add(currTop.val);
            } else {
                stack.push(currTop.right);
                stack.push(currTop);

                if(currTop.left != null) {
                    stack.push(currTop.left);
                }
            }
            
        }
        return result;
    }
}

