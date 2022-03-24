/*
https://leetcode.com/problems/minimum-interval-to-include-each-query/

Upshot:
- Sort all interval by start time, then end time (small to large)
- Sort all query from small to large
- Gradually add intervals to the priority queue if the interval is covering the current query
- Priority queue is ordered by interval length (smaller -> more priority)
- Poll the priority queue. If the interval does not cover q then keep polling. All the removed intervals are guaranteed to be unusable by
any latter query (since those query will be large than the current one, and the current one is already "too large", i.e. greater than end
time of the removed intervals. Poll until you see the first interval that cover query q - that is guaranteed to be the smallest interval. 
*/

class Solution {
    
    public int[] minInterval(int[][] intervals, int[] queries) {
        int m = intervals.length;
        int n = queries.length;
        List<int[]> map = new ArrayList<>();
        for(int ind = 0; ind < n; ind++) {
            map.add(new int[]{queries[ind], ind});
        }
        Arrays.sort(intervals, (i1, i2) -> compareInterval(i1, i2));
        PriorityQueue<int[]> pq = new PriorityQueue<>((i1, i2) -> compare(i1, i2));
        Collections.sort(map, (e1, e2) -> Integer.compare(e1[0], e2[0]));
        int i = 0;
        int[] result = new int[n];
        for(int[] tuple : map) {
            int val = tuple[0];
            int index = tuple[1];
            while(i < m && intervals[i][0] <= val) {
                pq.add(intervals[i]); 
                i++;
            }
            
            boolean flag = false;
            while(!pq.isEmpty()) {
                int[] top = pq.peek();
                if(top[0] <= val && val <= top[1]) {
                    result[index] = top[1] - top[0] + 1;
                    flag = true;
                    break;
                } else {
                    pq.remove();
                }
            }
            
            if(pq.isEmpty() & !flag) {
                result[index] = -1;
            }
            
        }
        return result;
    }
    
    private int compareInterval(int[] i1, int[] i2) {
        if(i1[0] < i2[0]) {
            return -1;
        } else if(i1[0] > i2[0]) {
            return 1;
        } else {
            if(i1[1] < i2[1]) {
                return -1;
            } else if(i1[1] > i2[1]) {
                return 1;
            } else {
                return 0;
            }
        }
    }
    
    private int compare(int[] i1, int[] i2) {
        int diff1 = i1[1] - i1[0];
        int diff2 = i2[1] - i2[0];
        if(diff1 < diff2) {
            return -1;
        } else if(diff1 > diff2) {
            return 1;
        } else {
            return 0;
        }
    }
    
}
