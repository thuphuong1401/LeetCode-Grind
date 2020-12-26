/*
https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
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


// My implementation - BFS
class Solution {
    public int maxDepth(Node root) {
        if(root == null) {
            return 0;
        }
        int depth = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Node curr = queue.remove();
                for(Node node : curr.children) {
                    queue.add(node);
                }
            }
            depth++;
        }
        return depth;
    }
}


// DFS approach
class Solution {
    public int maxDepth(Node root) {
        if(root == null) {
            return 0;
        }
        int curr = 0;
        for(Node node : root.children) {
            curr = Math.max(curr, maxDepth(node));
        }
        return 1 + curr;
    }
}

