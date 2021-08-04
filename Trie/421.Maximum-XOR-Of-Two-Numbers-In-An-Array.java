/*
https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
*/

class Node {
    Node[] children;
    //boolean isEndBit; => not really need this because every num is 32-bit
    
    public Node() {
        this.children = new Node[2];
        //this.isEndBit = false;
    }
}


class Trie {
    Node root;
    
    public Trie() {
        this.root = new Node();
    }
    
    public void add(int num) {
        Node curr = root;
        for(int i = 31; i >= 0; i--) {
            int currBit = ((num >> i) & 1);
            if(curr.children[currBit] == null) {
                Node newNode = new Node();
                curr.children[currBit] = newNode;
            }
            curr = curr.children[currBit];
        }
        //curr.isEndBit = true;
    }
    
    
    // find x in array s.t. (num ^ x) is max
    public int traverseXOR(int num) {
        int maxXOR = 0;
        Node curr = root;
        for(int i = 31; i >= 0; i--) {
            int currBit = ((num >> i) & 1);
            if(currBit == 0) {
                if(curr.children[1] != null) {
                    curr = curr.children[1];
                    maxXOR |= (1 << i);
                } else {
                    curr = curr.children[0];
                }
            } else {
                if(curr.children[0] != null) {
                    curr = curr.children[0];
                    maxXOR |= (1 << i);
                } else {
                    curr = curr.children[1];
                }
            }
        }
        
        return maxXOR;
        
    }
    
    
}

class Solution {
    public int findMaximumXOR(int[] nums) {
        int n = nums.length;
        int maxXOR = 0;
        Trie trie = new Trie();
        for(int num : nums) {
            trie.add(num);
        }
        for(int i = 0; i < n; i++) {
            int curr = nums[i];   
            maxXOR = Math.max(maxXOR, trie.traverseXOR(curr));
        }
        return maxXOR;
    }
}
