/*
https://leetcode.com/problems/my-calendar-iii/
*/

class MyCalendarThree {
    Map<Integer, Integer> arr;
    Map<Integer, Integer> lazy;
    int min;
    int max;
    
    public MyCalendarThree() {
        arr = new HashMap<>();
        lazy = new HashMap<>();
        min = 0;
        max = (int)1e9;
    }
    
    public int book(int start, int end) {
        update(start, end - 1, min, max, 0);       
        return arr.get(0);
    }
    
    private void update(int from, int to, int left, int right, int index) {
        if(left > right) {
            return;
        }
        
        if(lazy.get(index) != null && lazy.get(index) != 0) {
            arr.put(index, arr.getOrDefault(index, 0) + lazy.get(index));
            if(left != right) {
                lazy.put(2 * index + 1, lazy.getOrDefault(2 * index + 1, 0) + lazy.get(index));
                lazy.put(2 * index + 2, lazy.getOrDefault(2 * index + 2, 0) + lazy.get(index));
            }
            lazy.put(index, 0);
        }
        
        // no overlap condition
        if(from > right || to < left) {
            return;
        }
        
        // total overlap condition
        if(from <= left && to >= right) {
            arr.put(index, arr.getOrDefault(index, 0) + 1);
            if(left != right) {
                lazy.put(2 * index + 1, lazy.getOrDefault(2 * index + 1, 0) + 1);
                lazy.put(2 * index + 2, lazy.getOrDefault(2 * index + 2, 0) + 1);
            }
            return;
        }
        
        // otherwise partial overlap so look both left & right
        int mid = left + (right - left) / 2;
        update(from, to, left, mid, 2 * index + 1);
        update(from, to, mid + 1, right, 2 * index + 2);
        arr.put(index, Math.max(arr.getOrDefault(2 * index + 1, 0), arr.getOrDefault(2 * index + 2, 0)));
        
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */
