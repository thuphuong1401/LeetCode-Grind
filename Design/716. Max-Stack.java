/*
https://leetcode.com/problems/max-stack/
*/

/*
Solution using 2 stacks
*/
class MaxStack {
    Stack<Integer> stack;
    Stack<Integer> maxStack;
    
    /** initialize your data structure here. */
    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if(!maxStack.isEmpty()) {
            maxStack.push(Math.max(maxStack.peek(), x));
        } else {
            maxStack.push(x);
        }
    }
    
    public int pop() {
        maxStack.pop();
        return stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return maxStack.peek();
    }
    
    public int popMax() {
        Stack<Integer> aux = new Stack<>();
        int currMax = peekMax();
        while(!stack.isEmpty() && stack.peek() != currMax) {
            aux.push(pop());
        }
        pop();
        while(!aux.isEmpty()) {
            push(aux.pop());
        }
        return currMax;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
 
 
 
 
 
