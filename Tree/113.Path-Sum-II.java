/*
https://leetcode.com/problems/path-sum-ii/
*/


// My version
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
    List<List<Integer>> res;
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<List<Integer>>();
        path(root, sum, new ArrayList<Integer>());
        return res;
    }
    
    public void path(TreeNode root, int sum, ArrayList<Integer> arr) {
        if(root == null) {
            return;
        }
        
        arr.add(root.val);
        sum -= root.val;
        
        if(root.left == null && root.right == null) {
            if(sum == 0) {
                res.add(arr);  
                return;
            }
        } 
        
        path(root.left, sum, new ArrayList<Integer>(arr));
        path(root.right, sum, new ArrayList<Integer>(arr));
        
    }
}



// Got this idea from a solution
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
    List<List<Integer>> res;
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<List<Integer>>();
        path(root, sum, new ArrayList<Integer>());
        return res;
    }
    
    public void path(TreeNode root, int sum, ArrayList<Integer> arr) {
        if(root == null) {
            return;
        }
        
        arr.add(root.val);
        sum -= root.val;
        
        if(root.left == null && root.right == null) {
            if(sum == 0) {
                res.add(new ArrayList<>(arr));  
            }
        } else {
        
            path(root.left, sum, arr);
            path(root.right, sum, arr);
        }
        arr.remove(arr.size() - 1);
        
    }
}
