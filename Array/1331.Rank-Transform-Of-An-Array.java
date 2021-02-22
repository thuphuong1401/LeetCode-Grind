/*
https://leetcode.com/problems/rank-transform-of-an-array/
*/

/*
My implementation - pretty slow, time O(n log n), space O(n)
*/
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] copyArr = new int[n];
        int[] rank = new int[n];
        for(int i = 0; i < n; i++) {
            copyArr[i] = arr[i];
        }
        Arrays.sort(copyArr);
        for(int i : copyArr) {
            System.out.print(i + " ");
        }
        Map<Integer, Integer> mapIndex = new HashMap<>();
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(!mapIndex.containsKey(copyArr[i])) {
                mapIndex.put(copyArr[i], count);
                count++;
            }
        }
        
        for(int i = 0; i < n; i++) {
            rank[i] = mapIndex.get(arr[i]) + 1;    
        }
        
        return rank;
    }
}

