/*
https://leetcode.com/problems/path-sum/
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
Recursive method: 
- Time: visit every node in the tree once => O(N) time, N: number of nodes
- Space: 
  + Worst case: tree completely imbalanced (every node has 1 child): recursive call happens N times (height of tree) -> storage to keep the call stack is O(N)
  + Average/best case: tree completely balanced -> height of tree is log(N)
  => O(log(N))
*/
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        
        sum -= root.val;
        
        // is a leaf -> check whether sum == 0
        if(root.left == null && root.right == null) {
            return (sum == 0);    
        }
        
        // if not a leaf, recursively call the function on left & right child
        boolean leftSum = hasPathSum(root.left, sum);
        boolean rightSum = hasPathSum(root.right, sum);
        return (leftSum || rightSum);
        
    }
}

/*
Iterative method
Idea: Use DFS. Faster than BFS (worst case: have the same performance as BFS)
Use a stack. 
*/

class Pair {
    TreeNode node;
    int sum;
    
    public Pair(TreeNode node, int sum) {
        this.node = node;
        this.sum = sum;
    }
}

class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, sum));
        while(!stack.isEmpty()) {
            Pair top = stack.pop();
            TreeNode node = top.node;
            int remainSum = top.sum;
            if(node != null) {
                remainSum -= node.val;
                if(node.left == null && node.right == null && remainSum == 0) { // if current node is leaf, and the remaining sum is 0, there exists a path with the desired sum
                    return true;
                }
                // add children of top into the stack
                stack.add(new Pair(node.left, remainSum));
                stack.add(new Pair(node.right, remainSum));
            }
        }
        return false;
    }
}
