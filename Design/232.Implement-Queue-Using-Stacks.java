/*
https://leetcode.com/problems/implement-queue-using-stacks/
*/
class MyQueue {
    
    Stack<Integer> pushStack;
    Stack<Integer> popStack;
    
    /** Initialize your data structure here. */
    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        this.pushStack.push(x);
    }
    
    private void transferPushToPop() {
        while(this.pushStack.size() > 0) {
            this.popStack.push(this.pushStack.pop());
        }    
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(this.popStack.isEmpty()) {
            transferPushToPop();
        }
        return this.popStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(this.popStack.isEmpty()) {
            transferPushToPop();
        }
        return this.popStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(this.pushStack.isEmpty() && this.popStack.isEmpty()) {
            return true;
        }
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
