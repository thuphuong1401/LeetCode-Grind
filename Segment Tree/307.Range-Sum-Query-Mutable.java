/*
https://leetcode.com/problems/range-sum-query-mutable/
*/
class NumArray {
    int[] segTree;
    int[] nums;
    int n;
    
    public NumArray(int[] arr) {
        n = arr.length;
        nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = arr[i];
        }
        int h = (int)Math.ceil(log2(n));
        int sizeTree = 2 * (int)Math.pow(2, h) - 1;
        segTree = new int[sizeTree];
        buildTree(0, n-1, 0);
    }
    
    public void update(int index, int val) {
        updateQuery(0, n-1, 0, index, val);
    }
    
    public int sumRange(int left, int right) {
        return sumQuery(0, n-1, left, right, 0);
    }
    
    private double log2(int number) {
        return Math.log(number) / Math.log(2);
    }
    
    private void buildTree(int left, int right, int index) {
        if(left == right) {
            segTree[index] = nums[left];
            return;
        }
        
        int mid = (left + right) / 2;
        
        buildTree(left, mid, 2 * index + 1);
        buildTree(mid + 1, right, 2 * index + 2);
        
        segTree[index] = segTree[2 * index + 1] + segTree[2 * index + 2];
    }
    
    
    private void updateQuery(int left, int right, int index, int pos, int value) {
        if(pos < left || right < pos) {
            return;
        }
        
        if(left == right) {
            nums[pos] = value;
            segTree[index] = value;
            return;
        }
        
        int mid = (left + right)/2;
        if(pos <= mid) {
            updateQuery(left, mid, 2 * index + 1, pos, value);
        } else {
            updateQuery(mid + 1, right, 2 * index + 2, pos, value);
        }
        
        segTree[index] = segTree[2 * index + 1] + segTree[2 * index + 2];
    }
    
    
    private int sumQuery(int left, int right, int from, int to, int index) {
        if(from <= left && right <= to) {
            return segTree[index];
        }
        
        if(from > right || to < left) {
            return 0;
        }
        
        int mid = (left + right)/2;
        return sumQuery(left, mid, from, to, 2 * index + 1) + sumQuery(mid + 1, right, from, to, 2 * index + 2);
    }
    
    
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
