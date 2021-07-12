/*
https://leetcode.com/problems/sum-root-to-leaf-numbers/
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
My first solution
*/
class Solution {
    List<List<Integer>> paths;
    
    public int sumNumbers(TreeNode root) {
        paths = new ArrayList<>();
        allPaths(root, new ArrayList<>());
        int ans = 0;
        System.out.println(paths);
        for(List<Integer> path : paths) {
            StringBuilder sb = new StringBuilder();
            for(int i : path) {
                sb.append(i);
            }
            int num = Integer.parseInt(sb.toString());
            ans += num;
        }
        return ans;
    }
    
    private void allPaths(TreeNode root, List<Integer> currPath) {
        if(root == null) {
            return;
        }
        
        currPath.add(root.val);
        if(root.left == null && root.right == null) {
            paths.add(new ArrayList<>(currPath));
            currPath.remove(currPath.size() - 1);
            return;
        }
        
        allPaths(root.left, currPath);
        allPaths(root.right, currPath);
        
        currPath.remove(currPath.size() - 1);
    }
    
}


/*
Faster approach
*/
class Solution {
    int res;
    
    public int sumNumbers(TreeNode root) {
        res = 0;
        allPaths(root, new StringBuilder());
        return res;
    }
    
    private void allPaths(TreeNode root, StringBuilder sb) {
        if(root == null) {
            return;
        }
        
        int prevLength = sb.length();
        sb.append(root.val);
        
        if(root.left == null && root.right == null) {
            int temp = Integer.parseInt(sb.toString());
            res += temp;
            sb.setLength(prevLength);
            return;
        }
        
        allPaths(root.left, sb);
        allPaths(root.right, sb);
        
        sb.setLength(prevLength);
        
    }
    
}
