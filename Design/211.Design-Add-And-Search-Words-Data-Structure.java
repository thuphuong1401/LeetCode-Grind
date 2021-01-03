/*
https://leetcode.com/problems/design-add-and-search-words-data-structure/
*/

class Node {
    Node[] child;
    int countWord;
    
    public Node() {
        child = new Node[26];
        countWord = 0;
    }
}

class WordDictionary {
    Node root;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        int ch;
        Node temp = root;
        for(int i = 0; i < word.length(); i++) {
            ch = word.charAt(i) - 'a';
            if(temp.child[ch] == null) {
                temp.child[ch] = new Node();
            }
            temp = temp.child[ch];
        }
        temp.countWord++;
    }
    
    /*
    See '.' => search for all possible solution, then backtrack
    */
    public boolean search(String word) {
        return search(word, this.root, 0);
    }
    
    private boolean search(String word, Node node, int index) {
        if(index == word.length()) {
            return node.countWord > 0;
        }    
        if(word.charAt(index) != '.') {
            return (node.child[word.charAt(index) - 'a'] != null && search(word, node.child[word.charAt(index) - 'a'], index + 1));
        } else {
            for(Node n : node.child) {
                if(n != null && search(word, n, index+1)) {
                    return true;
                }
            }
            return false;
        }
    }
    
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
