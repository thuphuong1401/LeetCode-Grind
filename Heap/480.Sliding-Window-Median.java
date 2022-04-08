/*
https://leetcode.com/problems/sliding-window-median/
*/
class Solution {
    PriorityQueue<Integer> smallerHalf;
    PriorityQueue<Integer> largerHalf;
    int balance;
    
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] res = new double[n - k + 1];
        smallerHalf = new PriorityQueue<>(Collections.reverseOrder());
        largerHalf = new PriorityQueue<>();
        balance = 0; // smallerHalf.size() - largerHalf.size()
        
        /*
        Initialize the first window
        */
        List<Integer> firstK = new ArrayList<>();
        for(int j = 0; j < k; j++) {
            firstK.add(nums[j]);
        }
        Collections.sort(firstK);
        int i = 0;
        while(i < (k + 1)/2) {
            smallerHalf.add(firstK.get(i));
            i++;
        }
        while(i < k) {
            largerHalf.add(firstK.get(i));
            i++;
        } 
        
        if(smallerHalf.size() > largerHalf.size()) {
            balance = 1;
        }
        
        /*
        Sliding window
        */
        PriorityQueue<Integer> smallerRemoved = new PriorityQueue<>(Collections.reverseOrder());;
        PriorityQueue<Integer> largerRemoved = new PriorityQueue<>();

        while(i <= n) {
            /*
            Get median of current window
            */
            lazyRemove(smallerHalf, smallerRemoved);
            lazyRemove(largerHalf, largerRemoved);
            double median = 0.0;
            if(k % 2 == 0) {
                median = ((double)smallerHalf.peek() + (double)largerHalf.peek()) / 2.0;
            } else {
                median = smallerHalf.peek();
            }
            res[i - k] = median;
            if(i == n) {
                break;
            }
            
            /*
            Remove leftmost number from the previous window
            -> figure out what half it lies in
            -> add it to removed pq's
            */
            int toRemove = nums[i - k];
            int toAdd = nums[i];
            
            if(toRemove > smallerHalf.peek()) {
                largerRemoved.add(toRemove);
                balance++;
            } else {
                smallerRemoved.add(toRemove);
                balance--;
            }
            
            
            /*
            Rebalance 2 heaps
            */
            while(balance > 1) {
                lazyRemove(smallerHalf, smallerRemoved);
                largerHalf.add(smallerHalf.remove());
                balance -= 2;
            }
            
            while(balance < 0) {
                lazyRemove(largerHalf, largerRemoved);
                smallerHalf.add(largerHalf.remove());
                balance += 2;
            }
            
            /*
            Add upcoming element
            */
            if(balance % 2 == 0) {
                if(largerHalf.size() == 0) {
                    smallerHalf.add(toAdd);
                } else {
                    int candidate = largerHalf.peek();
                    if(candidate < toAdd) {
                        largerHalf.remove();
                        largerHalf.add(toAdd);
                        smallerHalf.add(candidate);  
                    } else {
                        smallerHalf.add(toAdd);
                    }
                }
                balance = 1;
            } else {
                if(smallerHalf.size() == 0) {
                    largerHalf.add(toAdd);
                } else {
                    int candidate = smallerHalf.peek();
                    if(candidate > toAdd) {
                        smallerHalf.remove();
                        smallerHalf.add(toAdd);
                        largerHalf.add(candidate);
                    } else {
                        largerHalf.add(toAdd);
                    }
                }
                balance = 0;
            }
            
            i++;
        }
        
        return res;
        
    }
    
    private void lazyRemove(PriorityQueue<Integer> pq, PriorityQueue<Integer> pqRemoved) {
        while(!pq.isEmpty() && !pqRemoved.isEmpty() && pq.peek().intValue() == pqRemoved.peek().intValue()) {
            pq.remove();
            pqRemoved.remove();
        }
    }
}
