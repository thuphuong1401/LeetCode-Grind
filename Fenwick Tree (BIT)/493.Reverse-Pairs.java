/*
https://leetcode.com/problems/reverse-pairs/
*/

class Solution {
    int n;
    int[] fenwick;
    
    public int reversePairs(int[] nums) {
        n = nums.length;
        fenwick = new int[2 * n + 1];
        
        long[] newNums = new long[2*n];
        for(int i = 0; i < n; i++) {
            newNums[i] = 1L * nums[i];
        }
        for(int i = n; i < 2 * n; i++) {
            newNums[i] = 2L * nums[i - n];
        }
        Arrays.sort(newNums);
        Map<Long, Integer> mapRank = new HashMap<>();
        int lastAvailableIndex = 1;
        mapRank.put(newNums[0], 1);
        for(int i = 1; i < 2*n; i++) {
            if(newNums[i-1] != newNums[i]) {
                mapRank.put(newNums[i], ++lastAvailableIndex);
            } 
        }
        
        // for demonstration purpose, don't actually use cnt
        int[] cnt = new int[2 * n + 1]; // count[rank[2 * nums[i]]]
        for(int i = 0; i < n; i++) {
            cnt[mapRank.get(2L * nums[i])]++;
            update(mapRank.get(2L * nums[i]), 1);
        }
        
        // arr[i] < arr[j] => rank[arr[i]] < rank[arr[j]]
        int ans = 0;
        for(int i = 0; i < n; i++) {
            int curr = nums[i];
            int rank = mapRank.get(1L * nums[i]);
            update(mapRank.get(2L * curr), -1);
            ans += getSum(rank - 1);
        }
        return ans;
    }
    
    
    private int getSum(int p) {
        int ans = 0;
        while(p > 0) {
            ans += fenwick[p];
            p -= (p & (-p));
        }
        return ans;
    }
    
    
    private void update(int index, int val) {
        while(index <= 2 * n) {
            fenwick[index] += val;
            index += (index & (-index));
        }
    }
    
    
}
