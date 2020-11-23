/*
https://leetcode.com/problems/invert-binary-tree/
See solution for a detailed explanation
A clear YouTube explanation: https://www.youtube.com/watch?v=_i0jqdVkObU
*/


/*
Recursive approach - My solution
*/
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null || root.left == null && root.right == null) {
            return root;
        } 
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}


/*
Recursive approach - Standard solution
Time: O(n), space: O(n)
*/
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return root;
        }
        // process the left subtree
        TreeNode left = invertTree(root.left);
        // process the right subtree
        TreeNode right = invertTree(root.right);
        // swap the pointers of right subtree and left subtree
        root.left = right;
        root.right = left;
        return root;
    }
}


/*
Iterative approach - similar to breadth first search
My implementation
*/
class Solution {
    public TreeNode invertTree(TreeNode root) {
        // store nodes whose left child and right child has NOT been swapped
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode n = q.remove(); // remove next node from the queue
            if(n != null) {
                TreeNode temp = n.left; // swap its children
                n.left = n.right;
                n.right = temp;
                q.add(n.left); // add the children into the queue
                q.add(n.right);
            }
        }
        return root;
    }
}

/*
Iterative approach - Solution's implementation
*/
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return root;
        } 
        // store nodes whose left child and right child has NOT been swapped
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode curr = q.remove();
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            if(curr.left != null) {
                q.add(curr.left);
            }
            if(curr.right != null) {
                q.add(curr.right);
            }
        }
        return root;
    }
}
