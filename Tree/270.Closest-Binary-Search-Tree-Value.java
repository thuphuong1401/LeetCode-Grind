/*
https://leetcode.com/problems/closest-binary-search-tree-value/
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
    List<Integer> list;
    public int closestValue(TreeNode root, double target) {
        list = new ArrayList<>();
        inOrder(root);
    
        if(target < list.get(0)) {
            return list.get(0);
        }
        
        if(target > list.get(list.size() - 1)) {
            return list.get(list.size() - 1);
        }
        
        for(int i = 0; i < list.size() - 1; i++) {
            if(list.get(i+1) >= target) {
                double dist1 = target - list.get(i);
                double dist2 = list.get(i+1) - target;
                if(dist1 > dist2) {
                    return list.get(i+1);
                } else {
                    return list.get(i);
                }
            }
        }
        return -1;
    }
    
    private void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}


/*
Binary search
*/

class Solution {
    public int closestValue(TreeNode root, double target) {
        int closest = root.val;
        while(root != null) {
            if(Math.abs(target - root.val) < Math.abs(target - closest)) {
                closest = root.val;
            }
            if(target > root.val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return closest;
    }
}
