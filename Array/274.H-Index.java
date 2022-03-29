/*
https://leetcode.com/problems/h-index/

1. For all i, count how many papers there are with i citations
2. Loop from right to left. Get the first value at which the bucket index (i.e. h-index) <= cumulative count for far, return it.
Cumulative count so far: numebr of papers with greater than i citations. 
*/

class Solution {
    public int hIndex(int[] citations) {
        int max = 1001;
        int[] count = new int[max];
        for(int cite : citations) {
            count[cite]++;
        }
        int h = max - 1;
        int c = 0;
        while(h >= 0) {
            c += count[h];
            if(c >= h) {
                break;
            }
            h--;
        }
        return h;
    }
}
