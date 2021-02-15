/*
https://leetcode.com/problems/asteroid-collision/
*/

/*
My implementation - Time O(n^2), Space O(n)
The solution said time is O(n)
*/
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int asteroid : asteroids) {
            stack.push(asteroid);
            while(stack.size() >= 2) {
                int top = stack.pop();
                int second = stack.pop();

                if(second > 0 && top < 0) {
                    int absSecond = Math.abs(second);
                    int absTop = Math.abs(top);
                    if(absTop > absSecond) {
                        stack.push(top);
                    } else if(absTop < absSecond) {
                        stack.push(second);
                    }
                } else {
                    stack.push(second);
                    stack.push(top);
                    break;
                }
            }
        }
        
        int[] answer = new int[stack.size()];
        int i = stack.size() - 1;
        while(!stack.isEmpty()) {
            answer[i] = stack.pop();
            i--;
        }
        return answer;
    }
}
