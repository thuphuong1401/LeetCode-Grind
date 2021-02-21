/*
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

/*
My implementation
*/
class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        List<Node> parentsOfP = new ArrayList<>();
        while(p != null) {
            parentsOfP.add(p);
            p = p.parent;
        }
        Node lca = null;
        int size = parentsOfP.size();
        boolean flag = false;
        while(q != null) {
            for(Node n : parentsOfP) {
                if(q.val == n.val) {
                    lca = q;
                    flag = true;
                    break;
                }
            }
            if(flag) {
                break;
            }
            q = q.parent;
        }
        
        return lca;
    }
}

/*
So smart, exactly the same problem as 160.Intersection of 2 linked lists
*/
class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node n1 = p;
        Node n2 = q;
        
        while(n1 != n2) {
            if(n1 == null) {
                n1 = q; 
            } else {
                n1 = n1.parent;
            }
            
            if(n2 == null) {
                n2 = p;
            } else {
                n2 = n2.parent;
            }
        }
        
        return n1;
    }
}
