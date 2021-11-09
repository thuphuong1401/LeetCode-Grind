/*
https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/

Main idea: Meet In the Middle
- Partition array into 2 equal parts
- Do bitmask on left part and right part
- Use binary search to search for subsetSum with minimum absolute diff.
*/
class Solution {
    
    public int minimumDifference(int[] nums) {
        int l = nums.length;
        int total = 0;
        for(int num : nums) {
            total += num;
        }
        
        int n = l/2;
        
        int[] firstHalf = new int[n];
        int[] secondHalf = new int[n];
        
        for(int i = 0; i < n; i++) {
            firstHalf[i] = nums[i];
            secondHalf[i] = nums[i + n];
        }
        
        List<Integer>[] subsetSumFirst = subsetSum(firstHalf);
        List<Integer>[] subsetSumSecond = subsetSum(secondHalf);
        
        int minDiff = Integer.MAX_VALUE;
        
        for(int i = 0; i <= n; i++) {
            List<Integer> tempFirst = subsetSumFirst[i];
            int restSize = n - i;
            List<Integer> tempSecond = subsetSumSecond[restSize];
            for(int num1 : tempFirst) {
                int sum = binarySearch(num1, tempSecond, total);
                if(sum < minDiff) {
                    minDiff = sum;
                }
            }
        }
        return minDiff;
    }
    
    private int binarySearch(int num, List<Integer> tempSecond, int total) {
        int l = 0;
        int r = tempSecond.size() - 1;
        int minDiff = Integer.MAX_VALUE;
        while(l <= r) {
            int mid = l + (r - l)/2;
            int sum = num + tempSecond.get(mid);
            int sum2 = total - sum;
            int absDiff = Math.abs(sum - sum2);
            if(absDiff < minDiff) {
                minDiff = absDiff;
            }
            /*
            Strive to make diff(sum, sum2) smaller
            */
            if(sum < sum2) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return minDiff;
    }
    
    private List<Integer>[] subsetSum(int[] nums) {
        int n = nums.length;
        List<Integer>[] ans = new ArrayList[n+1];
        for(int i = 0; i <= n; i++) {
            ans[i] = new ArrayList<>();
        }
        int max = (int)Math.pow(2, n);
        for(int mask = 0; mask <= max; mask++) {
            int index = 0;
            int currSubsetSum = 0;
            int tempMask = mask;
            int numElement = 0;
            while(tempMask != 0 && index < n) {
                int currBit = tempMask & 1;
                if(currBit == 1) {
                    currSubsetSum += nums[index];
                    numElement++;
                }
                index++;
                tempMask >>= 1;
            }
            ans[numElement].add(currSubsetSum);
        }
        for(List<Integer> list : ans) {
            Collections.sort(list);
        }
        return ans;
    }
} 
