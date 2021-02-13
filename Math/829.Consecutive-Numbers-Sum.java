/*
https://leetcode.com/problems/consecutive-numbers-sum/
*/

/*
See YouTube explanation of PyLenin
We need to find the number of arithemetic series (a, a+1, a+2, ... , a + n - 1) such that the sum of which is N
=> a + (a + 1) + ... + (a + n - 1) = N
=> (a + a + n - 1) * n / 2 = N
=> a = (2N + n - n^2) / 2n
(n is the number of numbers in the consective sum series)
Since a is a positive integer, 2N + n - n^2 / 2n must also be a positive integer. Every time there is a value of n s.t. a is positive, we have found 
a starting point for a consecutive sequence.
*/
class Solution {
    public int consecutiveNumbersSum(int N) {
        int count = 1; // include the number itself
        int n = 2; // a series of consecutive sum has at least 2 numbers 
        
        while(2*N + n - n*n > 0) { // is positive
            double a = (double)(2*N + n - n*n) / (double)(2*n);
            if(a - Math.floor(a) == 0.0) { // is integer
                count++;
            }
            n += 1;
        }
        return count;
    }
}
