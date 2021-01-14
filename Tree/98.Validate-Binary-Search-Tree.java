/*
https://leetcode.com/problems/validate-binary-search-tree/
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
// Fact: inorder traversal of a BST gives a sorted array
// Recursive solution: recursively check whether left subtree is in range (min, root.val), and right subtree is in range (root.val, max)
class Solution {
    
    public boolean isValidBST(TreeNode root) {
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean isBST(TreeNode root, Long min, Long max) {
        if(root == null) {
            return true;
        }
        if(root.val <= min || root.val >= max) {
            return false;
        }
        boolean x = isBST(root.left, min, (long)root.val);
        boolean y = isBST(root.right, (long)root.val, max);
        return x&y;
    }
}

/*
- Perform inorder traversal on the tree
- Save result in an array
- Iterate through the array: if there is one instance of arr[i] >= arr[i+1] (meaning that array not sorted in ascending order) then return false. Else return true
*/
class Solution {
    List<Integer> result = new ArrayList<>();
    
    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        
        for(int i = 0; i < result.size() - 1; i++) {
            if(result.get(i) >= result.get(i+1)) {
                return false;
            }
        }
        return true;
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


/*
Recursive inorder traversal which uses a TreeNode prev to store the previously visited inorder tree node.
*/
class Solution {
    TreeNode prev;
    
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return isBST(root);
    }
    
    public boolean isBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(!isBST(root.left)) {
            return false;
        }
        if(prev != null && prev.val >= root.val) {
            return false;
        }
        prev = root;
        if(!isBST(root.right)) {
            return false;
        }
        return true;
    }
}

