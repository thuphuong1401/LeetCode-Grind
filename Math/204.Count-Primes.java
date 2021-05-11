/*
https://leetcode.com/problems/count-primes/
Use Sieve of Eratosthenes
*/
class Solution {
    public int countPrimes(int n) {
        if(n <= 1) {
            return 0;
        }
        int numOfPrimes = 0;
        boolean[] marked = new boolean[n+1];
        marked[0] = true;
        marked[1] = true;
        for(int i = 2; i * i <= n; i++) {
            if(!marked[i]) {
                for(int j = i*i; j <= n; j += i) {
                    marked[j] = true;
                }   
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(!marked[i]) {
                numOfPrimes++;
            }
        }
        
        return numOfPrimes;
    }
}
