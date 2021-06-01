/*
https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
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
    List<String> list;
    
    public int sumRootToLeaf(TreeNode root) {
        list = new ArrayList<>();
        helper(root, new StringBuilder());
        int sum = 0;
        for(String s : list) {
            sum += binaryToInteger(s);
        }
        System.out.println(list);
        return sum;
    }
    
    private void helper(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append(" ");
            return;
        }
        sb.append(root.val);
        if(root.left == null && root.right == null) {
            list.add(sb.toString());
        }
        
        helper(root.left, sb);
        sb.deleteCharAt(sb.length() - 1);
        helper(root.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
    
    
    private int binaryToInteger(String binary) {
        int n = binary.length();
        int ans = 0;
        int exp = n-1;
        for(char c : binary.toCharArray()) {
            c -= '0';
            ans += (c * Math.pow(2, exp));
            exp--;
        }
        return ans;
    }
}



/*
A more space efficient solution
*/
class Solution {
    int sum;
    
    public int sumRootToLeaf(TreeNode root) {
        sum = 0;
        helper(root, new StringBuilder());
        return sum;
    }
    
    private void helper(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append(" ");
            return;
        }
        sb.append(root.val);
        if(root.left == null && root.right == null) {
            String ans = sb.toString();
            sum += binaryToInteger(ans);
        }
        
        helper(root.left, sb);
        sb.deleteCharAt(sb.length() - 1);
        helper(root.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
    
    
    private int binaryToInteger(String binary) {
        int n = binary.length();
        int ans = 0;
        int exp = n-1;
        for(char c : binary.toCharArray()) {
            c -= '0';
            ans += (c * Math.pow(2, exp));
            exp--;
        }
        return ans;
    }
    
}
