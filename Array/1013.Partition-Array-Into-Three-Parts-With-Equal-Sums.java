/*
https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/
*/
class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int total = 0;
        int n = arr.length;
        for(int i : arr) {
            total += i;
        }
        
        if(total % 3 != 0) {
            return false;
        } 

        int sumEach = total/3;
        int currSum = 0;
        int numParts = 0;
        for(int i = 0; i < n; i++) {
            int curr = arr[i];
            currSum += curr;
            if(currSum == sumEach) {
                currSum = 0;
                numParts++;
            }
        }
        return numParts>=3; // to catch all 0's cases, or cases where their are multiple segments each summing to 0
    }
}
