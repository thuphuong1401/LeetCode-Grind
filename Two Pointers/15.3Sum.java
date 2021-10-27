/*
https://leetcode.com/problems/3sum/
*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        for(int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < n - 2; i++) {
            int curr = nums[i];
            if(i > 0 && curr == nums[i-1]) {
                continue;
            }
            int j = i + 1;
            int k = n - 1;
            while(j < k) {
                int sum = curr + nums[j] + nums[k];
                if(sum == 0) {
                    result.add(new ArrayList<>());
                    result.get(result.size() - 1).add(curr);
                    result.get(result.size() - 1).add(nums[j]);
                    result.get(result.size() - 1).add(nums[k]);
                    /*
                    Skip the duplicates on both pointers
                    */
                    j++;
                    k--;
                    while(j < n-1 && nums[j] == nums[j-1]) {
                        j++;
                    } 
                    while(k > i + 1 && nums[k] == nums[k+1]) {
                        k--;
                    }
                } else {
                    if(sum < 0) {
                        j++;
                    } else {
                        k--;
                    }
                }
                
            } 
            
        }
        
        return result;
    }
}
