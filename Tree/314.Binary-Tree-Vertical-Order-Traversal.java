/*
https://leetcode.com/problems/binary-tree-vertical-order-traversal/
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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        int min = 0;
        int max = 0;
        Map<TreeNode, Integer> verticalOrder = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int order = 0;
        verticalOrder.put(root, order);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode top = queue.remove();
                if(top.left != null) {
                    int leftOrder = verticalOrder.get(top) - 1;
                    min = Math.min(min, leftOrder);
                    verticalOrder.put(top.left, leftOrder);
                    queue.add(top.left);
                }
                if(top.right != null) {
                    int rightOrder = verticalOrder.get(top) + 1;
                    max = Math.max(max, rightOrder);
                    verticalOrder.put(top.right, rightOrder);
                    queue.add(top.right);
                }
            }
        }
        
        for(int i = min; i <= max; i++) {
            result.add(new ArrayList<>());
        }
        
        int diff = 0 - min;
        queue.clear();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode top = queue.remove();
                int ord = verticalOrder.get(top) + diff;
                result.get(ord).add(top.val);
                
                if(top.left != null) {
                    queue.add(top.left);
                }
                
                if(top.right != null) {
                    queue.add(top.right);
                }
            }
        }
        
        return result;
    }
}




