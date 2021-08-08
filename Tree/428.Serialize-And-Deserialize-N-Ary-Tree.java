/*
https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree/
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

class Codec {
    
    // Encodes a tree to a single string.
    /*
    We don't know beforehand how many children each node has
    => Use # to signify the place where a collection of children of a node ends at.
    */
    public String serialize(Node root) {
        if(root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        String t = root.val + ",#,";
        sb.append(t);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Node top = queue.remove();
                for(Node child : top.children) {
                    queue.add(child);
                    String s = child.val + ",";
                    sb.append(s);
                }
                sb.append("#,");
            }
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data.equals("")) {
            return null;
        }
        String[] tokens = data.split(","); // each token is a node value. # is ending of a group of children
        Node root = new Node(Integer.parseInt(tokens[0]), new ArrayList<>());
        Queue<Node> queue = new LinkedList<>();
        int counter = 2;
        queue.add(root);
        while(!queue.isEmpty()) {
            Node top = queue.remove();
            while(!tokens[counter].equals("#")) {
                int val = Integer.parseInt(tokens[counter]);
                Node child = new Node(val, new ArrayList<>());
                top.children.add(child);
                queue.add(child);
                ++counter;
            }
            ++counter;
        }
        return root;
    }
}


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
