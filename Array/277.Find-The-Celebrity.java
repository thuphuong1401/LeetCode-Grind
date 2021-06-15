/*
https://leetcode.com/problems/find-the-celebrity/
This is a very nice medium problem.
Key observation:
- knows(a, b) = 1 means a knows b => a can't be the celeb, b can be
- knows(a, b) = 0 means a doesn't know b => a can be the celeb, b can't be
=> At every knows(a, b) call, we can deduce that either a or b can be a celeb.

*/


/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;
        /*
        Find the candidate for being the celeb
        */        
        for(int i = 1; i < n; i++) {
            if(knows(candidate, i)) {
                candidate = i;
            }
        }
        
        /*
        Actually verify whether the candidate is the celeb:
        1. The candidate knows no other vertex
        2. All other vertices know the candidate
        */
        for(int i = 0; i < n; i++) {
            if(i == candidate) {
                continue;
            }
            if(knows(candidate, i) || !knows(i, candidate)) {
                return -1;
            }
        }
        
        return candidate;
    }
}
