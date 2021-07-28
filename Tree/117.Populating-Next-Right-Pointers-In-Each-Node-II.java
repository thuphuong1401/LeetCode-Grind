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


/*
O(N) time, O(1) space. Kinda tricky.
BFS without queue
*/
class Solution {
    public Node connect(Node root) {
        if(root == null) {
            return root;
        }
        root.next = null;
        Node parent = root;
        Node firstNotNull = null;
        Node levelPointer = null;
        
        while(true) {
            
            while(parent != null) {
                if(parent.left != null) {
                    firstNotNull = parent.left;
                    break;
                } else if(parent.right != null) {
                    firstNotNull = parent.right;
                    break;
                }
                parent = parent.next;
            }
            
            
            if(parent == null) {
                break;
            }
            
            levelPointer = firstNotNull;
            
            while(parent != null) {
                if(parent.left != null && parent.left != levelPointer) {
                    levelPointer.next = parent.left;
                    levelPointer = levelPointer.next;
                } else if(parent.right != null && parent.right != levelPointer) {
                    levelPointer.next = parent.right;
                    levelPointer = levelPointer.next;
                    parent = parent.next;
                } else {
                    parent = parent.next;
                }
            }
            
            parent = firstNotNull;
            
        }
        
        return root;
        
    }
}
