/*
https://leetcode.com/problems/word-search-ii/
*/

class Node {
    Node[] children;
    boolean isWord;
    String wordSoFar;
    
    public Node() {
        this.children = new Node[26];
        this.isWord = false;
        this.wordSoFar = "";
    }
}


class Solution {
    
    static Node root;
    static int m, n;
    static Set<String> ans;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    
    public List<String> findWords(char[][] board, String[] words) {
        m = board.length;
        n = board[0].length;
        
        ans = new HashSet<>();
        root = new Node();
        for(String word : words) {
            addWord(word);
        }     
        
        visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                char curr = board[i][j];
                if(root.children[curr - 'a'] != null) {
                    backtracking(board, i, j, root.children[curr - 'a']);
                }        
            }
        }
        List<String> answer = new ArrayList<>(ans);
        return answer;
    }
    
    
    private static void addWord(String s) {
        int ch;
        Node temp = root;
        for(int i = 0; i < s.length(); i++) {
            ch = s.charAt(i) - 'a';
            if(temp.children[ch] == null) {
                temp.children[ch] = new Node();
            }
            temp = temp.children[ch];
        }
        temp.isWord = true;
        temp.wordSoFar = s;
    }
    
    
    private static void backtracking(char[][] board, int i, int j, Node curr) {
        visited[i][j] = true;
        
        if(curr.isWord == true) {
            ans.add(curr.wordSoFar);    
        }
        
        for(int ind = 0; ind < 4; ind++) {
            int ux = i + dx[ind];
            int uy = j + dy[ind];
            if(0 <= ux && ux < m && 0 <= uy && uy < n && !visited[ux][uy]) {
                char next = board[ux][uy];
                if (curr.children[next - 'a'] != null) {
                    backtracking(board, ux, uy, curr.children[next - 'a']);    
                    visited[ux][uy] = false;
                }
            } 
        }
        visited[i][j] = false;
    }
    
}
