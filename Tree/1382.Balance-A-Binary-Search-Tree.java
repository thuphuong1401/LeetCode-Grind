/*
https://leetcode.com/problems/balance-a-binary-search-tree/
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
My implementation
Drawback - costs memory due to creating new nodes.
*/
class Solution {
    List<Integer> nums = new ArrayList<>();
    
    public TreeNode balanceBST(TreeNode root) {
        inOrderTraversal(root);
        TreeNode newRoot = new TreeNode();
        newRoot = helper(0, nums.size() - 1, newRoot);
        return newRoot;
    }
    
    private TreeNode helper(int low, int high, TreeNode curr) {
        if(low <= high) {
            int mid = low + (high - low)/2;
            curr = new TreeNode(nums.get(mid));
            curr.left = helper(low, mid - 1, curr);
            curr.right = helper(mid + 1, high, curr);
            return curr;
        }
        return null;
    }
    
    private void inOrderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrderTraversal(root.left);
        nums.add(root.val);
        inOrderTraversal(root.right);
    }
}


/*
A more memory efficient implementation
*/
class Solution {
    List<TreeNode> nums = new ArrayList<>();
    
    public TreeNode balanceBST(TreeNode root) {
        inOrderTraversal(root);
        root = helper(0, nums.size() - 1, root);
        return root;
    }
    
    private TreeNode helper(int low, int high, TreeNode curr) {
        if(low <= high) {
            int mid = low + (high - low)/2;
            curr = nums.get(mid);
            curr.left = helper(low, mid - 1, curr);
            curr.right = helper(mid + 1, high, curr);
            return curr;
        }
        return null;
    }
    
    private void inOrderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrderTraversal(root.left);
        nums.add(root);
        inOrderTraversal(root.right);
    }
    
}
