/*
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
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
    
    int n;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        n = preorder.length;
        return build(preorder, 0, inorder, 0, n-1);
    }
    
    private TreeNode build(int[] preorder, int preIndex, int[] inorder, int inLeft, int inRight) {
        if(preIndex > n - 1 || inLeft > inRight) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preIndex]);
        
        int rootInorderIndex = -1; // index of current root in inorder array
        for(int i = inLeft; i <= inRight; i++) {
            if(inorder[i] == preorder[preIndex]) {
                rootInorderIndex = i;
            }
        }
        
        root.left = build(preorder, preIndex + 1, inorder, inLeft, rootInorderIndex - 1);
        root.right = build(preorder, preIndex + (rootInorderIndex - inLeft) + 1, inorder, rootInorderIndex + 1, inRight);
        
        return root;
    }
    
}


/*
Expedite implementation using hash map
*/
class Solution {
    
    int n;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        n = preorder.length;
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for(int i = 0; i < n; i++) {
            inorderMap.put(inorder[i], i);
        }
        return build(preorder, 0, inorder, 0, n-1, inorderMap);
    }
    
    private TreeNode build(int[] preorder, int preIndex, int[] inorder, int inLeft, int inRight, Map<Integer, Integer> inorderMap) {
        if(preIndex > n - 1 || inLeft > inRight) {
            return null;
        }
        
        int rootVal = preorder[preIndex];
        
        TreeNode root = new TreeNode(rootVal);
        int rootInorderIndex = inorderMap.get(rootVal); // index of current root in inorder array
        
        root.left = build(preorder, preIndex + 1, inorder, inLeft, rootInorderIndex - 1, inorderMap);
        root.right = build(preorder, preIndex + (rootInorderIndex - inLeft) + 1, inorder, rootInorderIndex + 1, inRight, inorderMap);
        
        return root;
    }
    
}
