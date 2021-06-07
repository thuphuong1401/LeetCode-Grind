/*
https://leetcode.com/problems/logger-rate-limiter/
*/

/*
My implementation - use 1 hash map, time O(1), space O(n)
Drawbacks: space always expand. This method does not optimize space
*/
class Logger {
    Map<String, Integer> messageLog;
    
    /** Initialize your data structure here. */
    public Logger() {
        this.messageLog = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!this.messageLog.containsKey(message)) {
            this.messageLog.put(message, timestamp+10);
            return true;
        } else {
            if(timestamp < this.messageLog.get(message)) {
                return false;
            } else {
                this.messageLog.put(message, timestamp+10);
                return true;
            }
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */


/*
Use a queue (array deque) to store all the messages within 10 seconds.
A hash set facilitates searching in the queue, O(1) look up
*/
class Pair {
    String mess;
    int time;
    
    public Pair(String mess, int time) {
        this.mess = mess;
        this.time = time;
    }
}
    
class Logger {
    Deque<Pair> queue; // all messages in this queue are not printable
    Set<String> set;
    
    /** Initialize your data structure here. */
    public Logger() {
        this.queue = new ArrayDeque<>();
        this.set = new HashSet<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        while(this.queue.size() > 0) {
            Pair head = this.queue.getFirst();
            if(timestamp - head.time >= 10) {
                this.queue.removeFirst();
                set.remove(head.mess);
            } else {
                break;
            }
        }
        
        if(this.set.contains(message)) {
            return false;
        } else {
            this.queue.add(new Pair(message, timestamp));
            this.set.add(message);
            return true;
        }
        
    }
}




