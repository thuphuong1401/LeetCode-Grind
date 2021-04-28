/*
https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
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
*/
class Solution {
    
    TreeNode root = null;
    
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int mid = low + (high - low)/2;
        root = new TreeNode(nums[mid]);
        root.left = helper(nums, 0, mid-1, new TreeNode());
        root.right = helper(nums, mid+1, high, new TreeNode());
        return root;
    }
    
    private TreeNode helper(int[] nums, int low, int high, TreeNode curr) {
        if(low <= high) {
            int mid = low + (high - low)/2;
            curr = new TreeNode(nums[mid]);
            curr.left = helper(nums, low, mid -1, curr);
            curr.right = helper(nums, mid + 1, high, curr);
            return curr;
        } 
        return null;
    }
}

/*
A slightly less verbose version
*/
class Solution {
    
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = helper(nums, 0, nums.length - 1, new TreeNode());
        return root;
    }
    
    private TreeNode helper(int[] nums, int low, int high, TreeNode curr) {
        if(low <= high) {
            int mid = low + (high - low)/2;
            curr = new TreeNode(nums[mid]);
            curr.left = helper(nums, low, mid -1, curr);
            curr.right = helper(nums, mid + 1, high, curr);
            return curr;
        } 
        return null;
    }
}
