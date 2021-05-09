/*
https://leetcode.com/problems/moving-average-from-data-stream/
*/


/*
My implementation 
next() takes O(n)
*/
class MovingAverage {
    Deque<Integer> queue;
    int size;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.queue = new ArrayDeque<>();
        this.size = size;
    }
    
    public double next(int val) {
        if(this.queue.size() >= this.size) {
            this.queue.removeFirst();
        }
        this.queue.addLast(val);
        double movingAverage = 0;
        for(int i : this.queue) {
            movingAverage += (double)i;
        }
        movingAverage /= this.queue.size();
        return movingAverage;
    } 
}


/*
O(1) time - neat 
*/
class MovingAverage {
    
    Deque<Integer> queue;
    int size;
    int currSum;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.queue = new ArrayDeque<>();  
        this.size = size;
        this.currSum = 0;
    }
    
    public double next(int val) {
        if(queue.size() >= this.size) {
            int out = queue.removeFirst();
            currSum -= out;
        }
        queue.add(val);
        currSum += val;
        double movingAverage = (double)currSum / (double)this.queue.size();
        return movingAverage;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */

