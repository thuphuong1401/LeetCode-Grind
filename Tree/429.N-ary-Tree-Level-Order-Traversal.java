/*
https://leetcode.com/problems/n-ary-tree-level-order-traversal/
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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> levelOrderListNodes = new ArrayList<>();
        if(root == null) {
            return levelOrderListNodes;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                Node top = queue.remove();
                level.add(top.val);
                for(Node child : top.children) {
                    queue.add(child);
                }
            }
            levelOrderListNodes.add(level);
        }
        return levelOrderListNodes;
        
    }
}
