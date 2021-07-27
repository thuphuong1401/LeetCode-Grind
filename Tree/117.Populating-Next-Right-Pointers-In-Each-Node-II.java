/*
https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/


/*
O(N) time, O(N) space solution
*/
class Solution {
    public Node connect(Node root) {
        if(root == null) {
            return root;
        }
        root.next = null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;
            for(int i = 0; i < size; i++) {
                Node top = queue.remove();
                if(prev != null) {
                    prev.next = top;
                }
                if(top.left != null) {
                    queue.add(top.left);
                }
                if(top.right != null) {
                    queue.add(top.right);
                }
                prev = top;
            }
        }
        return root;
    }
}



