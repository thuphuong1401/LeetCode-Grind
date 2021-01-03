/*
https://leetcode.com/problems/implement-trie-prefix-tree/
*/

class Node {
    public Node[] child;
    public int countWord;
    
    public Node() {
        child = new Node[26];
        countWord = 0;  
    }
}

class Trie {
    public Node root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node temp = root;
        int ch;
        for(int i = 0; i < word.length(); i++) {
            ch = word.charAt(i) - 'a';
            if(temp.child[ch] == null) {
                temp.child[ch] = new Node();
            }
            temp = temp.child[ch];
        }
        temp.countWord++;
    }
    
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node temp = root;
        int ch;
        for(int i = 0; i < word.length(); i++) {
            ch = word.charAt(i) - 'a';
            if(temp.child[ch] == null) {
                return false;
            }
            temp = temp.child[ch];
        }
        return temp.countWord > 0;
    }
    
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node temp = root;
        int ch;
        for(int i = 0; i < prefix.length(); i++) {
            ch = prefix.charAt(i) - 'a';
            if(temp.child[ch] == null) {
                return false;
            }
            temp = temp.child[ch];
        }
        return true;
    }
    
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
