/*
https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
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
    
    // inorder: left -> root -> right, postorder: left -> right -> root
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for(int i = 0; i < n; i++) {
            inorderMap.put(inorder[i], i);
        }
        return build(inorderMap, 0, n-1, postorder, n-1);
    }
    
    private TreeNode build(Map<Integer, Integer> inorderMap, int inStart, int inEnd, int[] postorder, int postIndex) {
        if(inStart > inEnd || postIndex < 0) {
            return null;
        }
        
        int rootVal = postorder[postIndex];
        System.out.println(rootVal);
        TreeNode root = new TreeNode(rootVal);
        int rootInorderIndex = inorderMap.get(rootVal);
        
        int sizeRightChild = inEnd - rootInorderIndex + 1;
        //int n = postorder.length;
        
        root.right = build(inorderMap, rootInorderIndex + 1, inEnd, postorder, postIndex - 1);
        root.left = build(inorderMap, inStart, rootInorderIndex - 1, postorder, postIndex - sizeRightChild);
        return root;
    }
    
}





