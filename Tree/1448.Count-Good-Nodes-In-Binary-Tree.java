/*
https://leetcode.com/problems/count-good-nodes-in-binary-tree/
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
First implementation with global count variable
*/
class Solution {
    int count;
    
    public int goodNodes(TreeNode root) {
        count = 0;
        countHelper(root, Integer.MIN_VALUE);
        return count;
    }
    
    public void countHelper(TreeNode root, int currMaxInPath) {
        if(root == null) {
            return;
        }
        
        if(root.val >= currMaxInPath) {
            count++;
        }
        currMaxInPath = Math.max(currMaxInPath, root.val);
        
        countHelper(root.left, currMaxInPath);
        countHelper(root.right, currMaxInPath);
    }
}


/*
Another implementation without global variables
*/
class Solution {
    
    public int goodNodes(TreeNode root) {
        int count = countHelper(root, Integer.MIN_VALUE, 0);
        return count;
    }
    
    public int countHelper(TreeNode root, int currMaxInPath, int count) {
        if(root == null) {
            return 0;
        }
        count = 0;
        if(root.val >= currMaxInPath) {
            count++;
        }
        currMaxInPath = Math.max(currMaxInPath, root.val);
        
        count += countHelper(root.left, currMaxInPath, count);
        count += countHelper(root.right, currMaxInPath, count);
        return count;
    }
    
}



