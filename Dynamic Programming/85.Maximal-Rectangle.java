/*
https://leetcode.com/problems/maximal-rectangle/
*/

class Solution {
    
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if(m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] histogram = new int[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0) {
                    if(matrix[i][j] == '1') {
                        histogram[i][j] = 1;
                    }
                } else {
                    histogram[i][j] = histogram[i-1][j];
                    if(matrix[i][j] == '1') {
                        histogram[i][j] = histogram[i-1][j] + 1;
                    } else {
                        histogram[i][j] = 0;
                    } 
                    
                }
            }
        }
        for(int i = 0; i < m ; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(histogram[i][j] + " ");
            }
            System.out.println();
        }
        
        int max = 0;
        for(int i = 0; i < m; i++) {
            max = Math.max(max, largestRectangleInHistogram(histogram[i]));
        }
        
        return max;
    }
    
    
    private int largestRectangleInHistogram(int[] histogram) {
        int n = histogram.length;
        // vs moi cot, gia su cot nay la height => width
        // height => cot thap nhat
        // width => between nearest shorter neighbor to the left and nearest shorter neighbor to the right
        // increasing stack
        // nearest shorter neighbor to the right => stack.peek()
        // nearest shorter neighbor to the left => cai ma minh add them vao stack
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        // build increasing stack
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && histogram[stack.peek()] > histogram[i]) {
                int height = histogram[stack.pop()]; 
                int width = 0;
                if(stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }
                int area = height * width;
                max = Math.max(max, area);
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            int height = histogram[stack.pop()];
            int width = 0;
            if(stack.isEmpty()) {
                width = n;
            } else {
                width = n - stack.peek() - 1;
            }
            int area = height * width;
            max = Math.max(max, area);
        }
        
        return max;
    }
    
}
