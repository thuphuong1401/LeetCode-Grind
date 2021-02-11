/*
https://leetcode.com/problems/diameter-of-n-ary-tree/
Big idea: for every node, calculate the 2 'longest' depth, sum them up. Find the longest among all nodes.
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    int max = 0;
    public int diameter(Node root) {
        dia(root);
        return max;
    }
    
    private int dia(Node root) {
        if(root == null) {
            return 0;
        }
        
        int firstMax = 0;
        int secondMax = 0;
        for(Node child : root.children) {
            int curr = dia(child);
            if(curr > firstMax) {
                secondMax = firstMax;
                firstMax = curr;
            } else if(curr > secondMax) {
                secondMax = curr;
            }
        }
        
        max = Math.max(max, firstMax + secondMax);
        
        return 1 + firstMax;
    }
    
}
