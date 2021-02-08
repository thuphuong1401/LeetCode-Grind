/*
https://leetcode.com/problems/two-sum-less-than-k/
Big idea: find the MAX among all the pairwise sum < k 
*/

/*
Brute force - List all 2 sums, put them all in a max heap, and poll until there's a sum that is smaller than k
Time O(n^2), Space O(n)
*/
class Solution { 
    public int twoSumLessThanK(int[] nums, int k) {
        Queue<Integer> sumOfPairs = new PriorityQueue<>(Collections.reverseOrder());
        int n = nums.length;
        for(int i = 0; i < n-1; i++) {
            for(int j = i+1; j < n; j++) {
                int currSum = nums[i] + nums[j];
                sumOfPairs.add(currSum);
            }
        }
        
        while(sumOfPairs.size() > 0 && sumOfPairs.peek() >= k) {
            sumOfPairs.remove();
        }
        
        if(sumOfPairs.size() > 0) {
            return sumOfPairs.remove();
        } else {
            return -1;
        }
    }
}


/*
Another solution - Time O(n^2), Space O(1)
*/
class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int n = nums.length;
        int smaller = -1;
        for(int i = 0; i < n-1; i++) {
            for(int j = i+1; j < n; j++) {
                int currSum = nums[i] + nums[j];
                if(currSum < k) {
                    smaller = Math.max(smaller, currSum);
                } 
            }
        }
        return smaller;
        
    }
}

/*
My implementation (based on binary search & two pointers)
Time O(N Log N), Space O(1)
*/
class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums.length - 1;
        int closest = -1;
        while(low < high) {
            int sum = nums[low] + nums[high];
            if(sum == k - 1) {
                return sum;
            }
            if(sum < k) {
                closest = Math.max(closest, sum);
                low++; 
            } else if(sum >= k) {
                high--;
            }
        }
        return closest;
    }
}
