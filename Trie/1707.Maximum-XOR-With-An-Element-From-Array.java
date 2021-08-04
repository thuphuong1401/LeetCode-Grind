/*
https://leetcode.com/problems/maximum-xor-with-an-element-from-array/
*/

class Node {
    Node[] children;
    
    public Node() {
        this.children = new Node[2];
    }
}


class Trie {
    Node root;
    
    public Trie() {
        this.root = new Node();
    }
    
    public void add (int num) {
        Node curr = root;
        for(int i = 31; i >= 0; i--) {
            int currBit = ((num >> i) & 1);
            if(curr.children[currBit] == null) {
                Node newNode = new Node();
                curr.children[currBit] = newNode;
            }
            curr = curr.children[currBit];
        }
    }
    
    
    // find x in array s.t. (num ^ x) is max
    public int solve (int num) {
        int maxXOR = 0;
        Node curr = root;
        for(int i = 31; i >= 0; i--) {
            int currBit = ((num >> i) & 1);
            if(currBit == 0) {
                if(curr.children[1] != null) {
                    curr = curr.children[1];
                    maxXOR |= (1 << i);
                } else if(curr.children[0] != null) {
                    curr = curr.children[0];
                } else {
                    return -1;
                }
            } else {
                if(curr.children[0] != null) {
                    curr = curr.children[0];
                    maxXOR |= (1 << i);
                } else if(curr.children[1] != null) {
                    curr = curr.children[1];
                } else {
                    return -1;
                }
            }
        }
        return maxXOR;   
    }
}


class Solution {
    public int[] maximizeXor(int[] nums, int[][] originalQueries) {
        int n = nums.length;
        int numQueries = originalQueries.length;
        int[] ans = new int[numQueries];
        int[][] queries = new int[numQueries][3];
        for(int i = 0; i < numQueries; i++) {
            queries[i][0] = originalQueries[i][0];
            queries[i][1] = originalQueries[i][1];
            queries[i][2] = i;
        }
        Arrays.sort(nums);
        Arrays.sort(queries, (q1, q2) -> Integer.compare(q1[1], q2[1]));
        Trie trie = new Trie();
        int i = 0;
        for(int j = 0; j < numQueries; j++) {
            int[] query = queries[j];
            int x_i = query[0];
            int m_i = query[1];
            int index = query[2];
            while(i < n && nums[i] <= m_i) {
                trie.add(nums[i]);
                i++;
            } 
            int res = trie.solve(x_i);
            ans[index] = res;
        }
        return ans;
    }
}
