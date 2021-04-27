/*
https://leetcode.com/problems/daily-temperatures/
*/

// Brute force method
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int n  = T.length;
        int[] answer = new int[n];
        for(int i = 0; i < n-1; i++) {
            for(int j = i+1; j < n; j++) {
                if(T[j] > T[i]) {
                    answer[i] = j-i;
                    break;
                }
            }
        }
        return answer;
    }
}


// Stack
// Maintain a decreasing stack
class Point {
    int value;
    int index;
    
    public Point(int value, int index) {
        this.value = value;
        this.index = index;
    }
}

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] ans = new int[n];
        Stack<Point> stack = new Stack<>();        
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && stack.peek().value < T[i]) {
                int dist = i - stack.peek().index;
                ans[stack.peek().index] = dist;
                stack.pop();
            }   
            stack.push(new Point(T[i], i));
        }
        return ans;
        
    }
} 
