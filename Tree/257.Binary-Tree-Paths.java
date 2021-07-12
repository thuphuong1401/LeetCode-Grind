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

// Recursive but not using StringBuilder
class Solution {
    List<String> answer;
    
    public List<String> binaryTreePaths(TreeNode root) {
        answer = new ArrayList<>();
        traverse(root, "");
        return answer;
    }
    
    public void traverse(TreeNode root, String s) {
        if(root == null) {
            return;
        }
        
        s += root.val;
        
        if(root.left == null && root.right == null) {
            answer.add(s);
        } else {
            s += "->";
            traverse(root.left, s);
            traverse(root.right, s);
        }
    }   
}



/*
Another recursive solution
*/
class Solution {
    List<String> ans;
    
    public List<String> binaryTreePaths(TreeNode root) {
        ans = new ArrayList<>();
        allPaths(root, new StringBuilder());
        return ans;
    }
    
    private void allPaths(TreeNode root, StringBuilder sb) {
        if(root == null) {
            return;
        }
        
        int currLength = sb.length();
        sb.append(root.val);
        
        if(root.left == null && root.right == null) {
            ans.add(sb.toString());
            return;
        }
        
        if(root.left != null) {
            int prevLength = sb.length();
            sb.append("->");
            allPaths(root.left, sb);
            sb.setLength(prevLength);    
        }
        
        if(root.right != null) {
            int prevLength = sb.length();
            sb.append("->");
            allPaths(root.right, sb);
            sb.setLength(prevLength);
        }
        
        sb.setLength(currLength);  
    }
    
}
