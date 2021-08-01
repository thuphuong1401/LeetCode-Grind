/*
https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
*/

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int pt1 = 0;
        int pt2 = 0;
        int m = nums1.length;
        int n = nums2.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> compare(nums1, nums2, a, b));
        
        pq.add(new int[]{pt1, pt2});
        
        while(ans.size() < Math.min(k, m*n)) {
            int[] indexPair = pq.remove();
            int first = indexPair[0];
            int second = indexPair[1];
            while(!pq.isEmpty() && first == pq.peek()[0]  && second == pq.peek()[1]) {
                pq.remove();
            } 
            
            ans.add(new ArrayList<>());
            
            int tempSize = ans.size() - 1;
            ans.get(tempSize).add(nums1[first]);
            ans.get(tempSize).add(nums2[second]);
            
            if(first < m-1) {
                int[] newPair1 = new int[]{first + 1, second};    
                pq.add(newPair1);
            }
            
            if(second < n-1) {
                int[] newPair2 = new int[]{first, second + 1};
                pq.add(newPair2);
            }
            
        }
        
        return ans;
    }
    
    
    public int compare(int[] nums1, int[] nums2, int[] a, int[] b) {
        int sum1 = nums1[a[0]] + nums2[a[1]];
        int sum2 = nums1[b[0]] + nums2[b[1]];
        
        if(sum1 != sum2) {
            return (sum1 - sum2);
        } else {
            if(a[0] != b[0]) {
                return (a[0] - b[0]);
            } else {
                return (a[1] - b[1]);
            }
        }
        
    }
    
    
}

