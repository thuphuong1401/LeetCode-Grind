/*
https://leetcode.com/problems/find-median-from-data-stream/
*/
class MedianFinder {

    int size;
    PriorityQueue<Integer> smallerHalf;
    PriorityQueue<Integer> largerHalf;
    
    public MedianFinder() {
        size = 0;
        smallerHalf = new PriorityQueue<>(Collections.reverseOrder()); // max heap to store smaller half
        largerHalf = new PriorityQueue<>(); // min heap to store larger half
    }
    
    /*
    Rules:
    - odd size -> add to smaller half by default
    - even size -> add to larger half by default
    - 2 candidates to consider: num and peek of the other heap. 
    */
    public void addNum(int num) {
        size++;
        if(size % 2 == 1) {
            if(largerHalf.size() == 0) {
                smallerHalf.add(num);
            } else {
                int candidate = largerHalf.peek();
                if(candidate < num) {
                    largerHalf.remove();
                    largerHalf.add(num);
                    smallerHalf.add(candidate);  
                } else {
                    smallerHalf.add(num);
                }
            }
        } else {
            if(smallerHalf.size() == 0) {
                largerHalf.add(num);
            } else {
                int candidate = smallerHalf.peek();
                if(candidate > num) {
                    smallerHalf.remove();
                    smallerHalf.add(num);
                    largerHalf.add(candidate);
                } else {
                    largerHalf.add(num);
                }
            }
        }
    }
    
    public double findMedian() {
        double median = 0.0;
        if(size % 2 == 1) {
            median = smallerHalf.peek();
        } else {
            median = (smallerHalf.peek() + largerHalf.peek()) / 2.0;
        }
        return median;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

/*

min_heap -> store the larger half
max_heap -> store the smaller half
-> maintain 2 heap such that they only differ by 1 

addNum -> add to either min or max heap depending on even/odd
odd -> increase max_heap ->

even -> increase min_heap -> either incoming data or max of smaller part, whichever is larger
     -> smaller one add to max_heap?

findMedian -> odd -> max_heap
           -> even -> pop max, min, get avg


*/
