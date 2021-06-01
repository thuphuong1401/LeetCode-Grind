/*
https://leetcode.com/problems/count-of-smaller-numbers-after-self/
*/
class Solution {
    int[] fen;
    int n;
    int MAX = 2 * (int)1e4 + 1;
    
    public List<Integer> countSmaller(int[] nums) {
        n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int[] numsCopy = new int[n];
        for(int i = 0; i < n; i++) {
            numsCopy[i] = nums[i];
        }
        Arrays.sort(numsCopy);
        int ind = 1;
        int[] newNums = new int[n];
        Map<Integer, Integer> compressed = new HashMap<>();
        compressed.put(numsCopy[0], ind);
        for(int i = 1; i < n; i++) {
            if(numsCopy[i] != numsCopy[i-1]) {
                ind++;
            }
            compressed.put(numsCopy[i], ind);
        }
        
        for(int i = 0; i < n; i++) {
            newNums[i] = compressed.get(nums[i]);
        }
        
        fen = new int[MAX];
        
        /*
        for(int i = n-1; i >= 0; i--) {
            int curr = newNums[i];
            ans.add(getSum(curr - 1));
            update(curr, 1);
        }
        Collections.reverse(ans);
        */
        
        for(int i = 0; i < n; i++) {
            update(newNums[i], 1);
        }
        
        for(int i = 0; i < n; i++) {
            int curr = newNums[i];
            update(curr, -1);
            ans.add(getSum(curr - 1));
        }
        
        return ans;
    }
    
    private void update(int index, int value) {
        int i = index;
        while(i <= MAX) {
            fen[i] += value;
            i += (i & (-i));
        }
    }
    
    private int getSum(int p) {
        int sum = 0;
        while(p > 0) {
            sum += fen[p];
            p -= (p & (-p));
        }
        return sum;
    }
    
}
