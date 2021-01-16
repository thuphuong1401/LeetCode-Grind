/*
https://leetcode.com/problems/find-all-the-lonely-nodes/
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
 
// Recursive way
class Solution {
    List<Integer> lonelyNodes;
    
    public List<Integer> getLonelyNodes(TreeNode root) {
        lonelyNodes = new ArrayList<>();
        findLonelyNodes(root);
        return lonelyNodes;
    }
    
    private void findLonelyNodes(TreeNode root) {
        if(root == null) {
            return;
        }
        
        if(!(root.left != null && root.right != null)) {
            if(root.left != null) {
                lonelyNodes.add(root.left.val);
            }
            if(root.right != null) {
                lonelyNodes.add(root.right.val);
            }
        }
        
        findLonelyNodes(root.left);
        findLonelyNodes(root.right);
    }
}



// Iterative way, a bit lengthy, still gets accepted with low memory usage
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
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode top = queue.remove();
                if(!(top.left != null && top.right != null)) {
                    if(top.left != null) {
                        res.add(top.left.val);
                        queue.add(top.left);
                    }
                    if(top.right != null) {
                        res.add(top.right.val);
                        queue.add(top.right);
                    }
                } else {
                    if(top.left != null) {
                        queue.add(top.left);
                    }
                    if(top.right != null) {
                        queue.add(top.right);
                    }
                }
            }
            
        }
        return res;
    }
}
