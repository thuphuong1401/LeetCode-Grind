/*
https://leetcode.com/problems/falling-squares/
*/

class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        int n = positions.length;
        List<Integer> ans = new ArrayList<>();
        SegTree segTree = new SegTree();
        for(int[] pos : positions) {
            int left_i = pos[0];
            int sideLength = pos[1];
            segTree.updateRangeLazy(left_i, sideLength);
            int currMax = segTree.arr.get(0);
            ans.add(currMax);
        }
        return ans;
    }
}


class SegTree {
    Map<Integer, Integer> arr;
    Map<Integer, Integer> lazy;
    int MAX = (int)1e8;
    
    public SegTree() {
        arr = new HashMap<>();
        lazy = new HashMap<>();
    }
    
    public int maxQuery(int from, int to, int left, int right, int index) {
        
        if(left > right) {
            return 0;
        }
        
        if(lazy.get(index) != null && lazy.get(index) != 0) {
            arr.put(index, lazy.getOrDefault(index, 0)); 
            if(left != right) {
                lazy.put(2 * index + 1, lazy.getOrDefault(index, 0));
                lazy.put(2 * index + 2, lazy.getOrDefault(index, 0));
            }
            lazy.put(index, 0);
            
        }
        
        // no overlap
        if(from > right || to < left) {
            return 0;
        }
        
        // total overlap
        if(from <= left && to >= right) {
            return arr.getOrDefault(index, 0);
        }
        
        // partial overlap
        int mid = left + (right - left)/2;
        return Math.max(maxQuery(from, to, left, mid, 2 * index + 1), maxQuery(from, to, mid + 1, right, 2 * index + 2));
    }
    
    
    /*
    - Query for the max in range (left, left + sideLength - 1) before letting the square fall  
    - Let the square fall then update range (left, left + sideLength - 1) by sideLength + max.
    */
    public void updateRangeLazy(int left_i, int sideLength) {
        int max = maxQuery(left_i, left_i + sideLength - 1, 0, MAX, 0);
        update(left_i, left_i + sideLength - 1, 0, MAX, sideLength + max, 0);    
    }
    
    
    public void update(int from, int to, int left, int right, int delta, int index) {
        if(left > right) {
            return;
        }
        
        if(lazy.get(index) != null && lazy.get(index) != 0) {
            arr.put(index, lazy.get(index));
            if(left != right) {
                lazy.put(2 * index + 1, lazy.get(index));
                lazy.put(2 * index + 2, lazy.get(index));
            }
            lazy.put(index, 0);
        }
        
        // no overlap condition
        if(from > right || to < left) {
            return;
        }
        
        // total overlap condition
        if(from <= left && to >= right) {
            arr.put(index, delta);
            if(left != right) {
                lazy.put(2 * index + 1, delta);
                lazy.put(2 * index + 2, delta);
            }
            return;
        }
        
        // otherwise partial overlap so look both left & right
        int mid = left + (right - left)/2;
        update(from, to, left, mid, delta, 2 * index + 1);
        update(from, to, mid + 1, right, delta, 2 * index + 2);
        arr.put(index, Math.max(arr.getOrDefault(2 * index + 1, 0), arr.getOrDefault(2 * index + 2, 0)));
        
    }
    
}


