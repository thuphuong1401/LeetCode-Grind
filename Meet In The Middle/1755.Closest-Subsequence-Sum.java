/*
https://leetcode.com/problems/closest-subsequence-sum/
*/

class Solution {
    
    int minAbsDiff = Integer.MAX_VALUE;
    
    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;
        int[] firstHalf = new int[n/2];
        int[] secondHalf = new int[n - n/2];
        for(int i = 0; i < n/2; i++) {
            firstHalf[i] = nums[i];
        }
        for(int i = n/2; i < n; i++) {
            secondHalf[i-n/2] = nums[i];
        }
        List<Integer> subsetSumsA = subsetSum(firstHalf);
        List<Integer> subsetSumsB = subsetSum(secondHalf);
        
        Collections.sort(subsetSumsA);
        Collections.sort(subsetSumsB);
        
        if(subsetSumsA.contains(goal) || subsetSumsB.contains(goal)) {
            return 0;
        }
        
        for(int i = 0; i < subsetSumsA.size(); i++) {
            searchAbsDiff(subsetSumsA.get(i), subsetSumsB, goal);
        }
        
        return minAbsDiff;
        
    }
    
    
    private void searchAbsDiff(int val, List<Integer> arr, int goal) {
        int low = 0;
        int high = arr.size() - 1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            int sum = arr.get(mid) + val;
            minAbsDiff = Math.min(minAbsDiff, Math.abs(sum - goal));
            if(sum == goal) {
                return;
            } else if(sum > goal) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
    }
    
    
    private List<Integer> subsetSum(int[] nums) {
        
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int max = (int)Math.pow(2, n);
        for(int mask = 0; mask <= max; mask++) {
            int index = 0;
            int currSubsetSum = 0;
            int tempMask = mask;
            while(tempMask != 0 && index < n) {
                int currBit = tempMask & 1;
                if(currBit == 1) {
                    currSubsetSum += nums[index];
                }
                index++;
                tempMask >>= 1;
            }
            ans.add(currSubsetSum);
        }
        return ans;
    }
    
}

