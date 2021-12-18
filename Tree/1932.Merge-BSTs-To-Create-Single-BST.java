/*
https://leetcode.com/problems/merge-bsts-to-create-single-bst/
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
class Solution {
    
    public TreeNode canMerge(List<TreeNode> trees) {
        Map<Integer, TreeNode> rootValToNode = new HashMap<>();
        
        // can only have 1 node for each leaf value
        Map<Integer, TreeNode> leafValToNode = new HashMap<>();
        
        for(int i = 0; i < trees.size(); i++) {
            TreeNode root = trees.get(i);
            TreeNode left = root.left;
            TreeNode right = root.right;
            
            int rootVal = root.val;
            int leftVal = -1, rightVal = -1;
            if(left != null) {
                leftVal = left.val;
                if(!leafValToNode.containsKey(leftVal)) {
                    leafValToNode.put(leftVal, left);
                } else {
                    return null;
                }
            }
            
            if(right != null) {
                rightVal = right.val;
                if(!leafValToNode.containsKey(rightVal)) {
                    leafValToNode.put(rightVal, right);
                } else {
                    return null;
                }
            }
            
            rootValToNode.put(root.val, root);
        }
        
        TreeNode mainBST = null;
        
        for(TreeNode root : rootValToNode.values()) {
            if(!leafValToNode.containsKey(root.val)) {
                if(mainBST == null) {
                    mainBST = root;
                } else {
                    return null;
                }
            }
        }
        
        if(mainBST == null) {
            return null;
        }
        
        rootValToNode.remove(mainBST.val);
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(mainBST);
        
        while(!queue.isEmpty()) {
            TreeNode curr = queue.remove(); // leaf
            TreeNode left = curr.left;
            TreeNode right = curr.right;
            
            if(left == null && right == null && rootValToNode.containsKey(curr.val)) {
                TreeNode root = rootValToNode.get(curr.val); // root
                curr.left = root.left;
                curr.right = root.right;
                rootValToNode.remove(curr.val);
            }
            
            if(curr.left != null) {
                queue.add(curr.left);
            }
            
            if(curr.right != null) {
                queue.add(curr.right);
            }
        }
        
        boolean isBST = isValidBST(mainBST);
        
        if(isBST && rootValToNode.size() == 0) {
            return mainBST;
        } else {
            return null;
        }
        
    }
    
    
    
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
        
        boolean leftIsBST = isBST(root.left, min, (long)root.val);
        boolean rightIsBST = isBST(root.right, (long)root.val, max);
        
        return leftIsBST&rightIsBST;
        
    }
}
