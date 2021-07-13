/*
https://leetcode.com/problems/n-ary-tree-preorder-traversal/
*/
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        stack.push(root);
        
        while(!stack.isEmpty()) {
            Node currTop = stack.pop();
            result.add(currTop.val);
            
            for(int i = currTop.children.size() - 1; i >= 0; i--) {
                Node child = currTop.children.get(i);
                if(child != null) {
                    stack.add(child);
                }
            }
            
        }
        
        return result;
    }
}
