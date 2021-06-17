/*
https://leetcode.com/problems/implement-rand10-using-rand7/
*/

/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int result = 40;
        while(result >= 40) { // rejection sampling
            result = 7 * (rand7() - 1) + (rand7() - 1); // [0, 48]
        }
        return result % 10 + 1;
    }
}
