/*
https://leetcode.com/problems/subarray-sums-divisible-by-k/
*/

/*
Based on this idea: if arr[0...j] % K = n,  arr[0...i] % K = n then arr[i...j] is divisible by K 
=> Need to count the frequency of arr[0...j] % K == arr[0...i] % K
*/
class Solution {
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // when the subarray contains just 1 element divisible by K
        int sum = 0;
        int count = 0;
        for(int val : A) {
            sum += val;
            int modSum = sum % K >= 0 ? sum % K : sum % K + K; // if mod < 0, add K to mod
            count += map.getOrDefault(modSum, 0);
            map.put(modSum, map.getOrDefault(modSum, 0) + 1);
        }
        return count;
    }
}
