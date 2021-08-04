/*
https://leetcode.com/problems/longest-word-in-dictionary/
*/

class Node {
    Node[] children;
    boolean isWord;
    
    public Node() {
        this.children = new Node[26];
        isWord = false;
    }
}

class Trie {
    Node root;
    String longestWord;
    
    public Trie() {
        this.root = new Node();
        this.longestWord = "";
    }
    
    public boolean isLeaf(Node curr) {
        for(int i = 0; i < 26; i++) {
            if(curr.children != null) {
                return false;
            }
        }
        return true;
    }
    
    public void add(String s) {
        Node curr = root;
        for(char c : s.toCharArray()) {
            if(curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new Node();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }
    
    public void maxLengthWord(Node curr, StringBuilder currPath) {
        for(int i = 0; i < 26; i++) {
            Node child = curr.children[i];
            if(child != null && child.isWord) {
                int prevSize = currPath.length();
                currPath.append((char)('a' + i));
                if(currPath.length() > this.longestWord.length()) {
                    longestWord = currPath.toString();
                }
                maxLengthWord(child, currPath);
                currPath.setLength(prevSize);
            } else {
                continue;
            }
        }
    }
    
    
}

class Solution {
    public String longestWord(String[] words) {
        int n = words.length;
        Trie trie = new Trie();
        for(int i = 0; i < n; i++) {
            String currWord = words[i];
            trie.add(currWord);
        }
        trie.maxLengthWord(trie.root, new StringBuilder());
        return trie.longestWord;
    }
}
