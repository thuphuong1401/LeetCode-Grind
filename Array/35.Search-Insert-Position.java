class Solution {
    
    // binary search first position >= target
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int index = -1;
        
        if(target <= nums[0]) {
            return 0;
        } 
        if(nums[high] == target) {
            return high;
        } 
        if(target > nums[high]) {
            return high+1;
        }
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(mid != 0 && nums[mid] >= target && nums[mid-1] < target) {
                index = mid;
                break;
            } else if(nums[mid] < target) {
                low = mid+1;
            } else if(nums[mid] > target) {
                high = mid-1;
            }
            System.out.println(low + " " + high);
        }
        return index;
    }
}



class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return low;
    }
}
