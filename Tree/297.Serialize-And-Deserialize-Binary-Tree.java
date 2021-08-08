/*
https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

Idea:
1. Serialize: use BFS level order traversal, add append node value into string
2. Deserialize: 
- Every not-null nodes has 2 children in the encoded string
- First token is root. 
- Use queue: at every step, pop 1 node, read in 2 next tokens to create left & right child, add left child and right child into queue.
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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode top = queue.remove();
                if(top == null) {
                    sb.append("null,");
                } else {
                    String s = Integer.toString(top.val) + ",";
                    sb.append(s);
                    queue.add(top.left);
                    queue.add(top.right);
                }
            }
        }
        sb.setLength(sb.length() - 1);
        //System.out.println(sb.toString()); 
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) {
            return null;
        }
        String[] nodes = data.split(",");
        Integer[] nodeVal = new Integer[nodes.length];
        for(int i = 0; i < nodes.length; i++) {
            if(nodes[i].equals("null")) {
                nodeVal[i] = null;
            } else {
                nodeVal[i] = Integer.parseInt(nodes[i]);
            }
        }
        TreeNode root = new TreeNode(nodeVal[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            TreeNode top = queue.remove();
            if(top == null) {
                continue;
            }
            Integer left = nodeVal[++count];
            Integer right = nodeVal[++count];
            TreeNode leftChild = null;
            if(left != null) {
                leftChild = new TreeNode(left);
            } 
            top.left = leftChild;
            TreeNode rightChild = null;
            if(right != null) {
                rightChild = new TreeNode(right);
            }
            top.right = rightChild;

            queue.add(leftChild);
            queue.add(rightChild);

        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
