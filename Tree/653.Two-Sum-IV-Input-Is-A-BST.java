/*
https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
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
My implementation - Time O(N), Space O(N)
This is the optimal solution. A slightly better version:
- inOrder traversal
- Use 2 pointers 2 sum method
*/
class Solution {
    
    List<Integer> res;
    
    public boolean findTarget(TreeNode root, int k) {
        res = new ArrayList<>();
        inOrder(root);
        Set<Integer> set = new HashSet<>();
        for(int i : res) {
            if(set.contains(k - i)) {
                return true;
            }
            set.add(i);
        }
        return false;
    }
    
    
    public void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        
        inOrder(root.left);
        res.add(root.val);
        inOrder(root.right);   
    }
}


