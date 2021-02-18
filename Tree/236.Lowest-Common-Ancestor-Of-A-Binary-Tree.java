/*
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
*/

/*
My implementation - long, and kinda brute force
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode lca;
    boolean pFound;
    boolean qFound;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode top = queue.remove();
                pFound = false;
                qFound = false;
                dfs(top, p, q);
                
                if(pFound&qFound) {
                    lca = top;
                }
                if(top.left != null) {
                    queue.add(top.left);
                }
                if(top.right != null) {
                    queue.add(top.right);
                }
            }
        }
        return lca;
    }
    
    
    private void dfs(TreeNode curr, TreeNode p, TreeNode q) {
        if(curr == null) {
            return;
        }
        
        dfs(curr.left, p, q);
        
        if(curr.val == p.val) {
            pFound = true;
        }
        
        if(curr.val == q.val) {
            qFound = true;
        }
        
        dfs(curr.right, p, q);
    }
    
}


/*
Recursive method
Time O(n)
Space O(n) - recursion stack
*/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }    
        
        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);
        
        if(leftLCA != null && rightLCA != null) {
            return root;
        }
        
        if(leftLCA != null) {
            return leftLCA;
        } else {
            return rightLCA;
        } 
        
        
    }
}


/*
Iterative
*/

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>(); // node, parent
        
        queue.add(root);
        parent.put(root, null);
        while(!queue.isEmpty() || !parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode top = queue.remove();
            if(top.left != null) {
                queue.add(top.left);
                parent.put(top.left, top);
            }
            if(top.right != null) {
                queue.add(top.right);
                parent.put(top.right, top);
            }
        }
        
        /*
        - List all ancestors of P
        - While finding ancestors for q, the first ancestor appearing in the set of ancestors of p is the LCA of p and q
        */
        Set<TreeNode> parentsOfP = new HashSet<>();
        while(p != null) {
            parentsOfP.add(p);
            p = parent.get(p);
        }
        
        while(!parentsOfP.contains(q)) {
            q = parent.get(q);
        }
        
        return q;
        
    }
}
