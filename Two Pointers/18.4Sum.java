/*
https://leetcode.com/problems/4sum/
*/
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        Set<String> visited = new HashSet<>();
        for(int i = 0; i < n-3; i++) {
            for(int j = i+1; j < n-2; j++) {
                String s = nums[i] + " " + nums[j];
                if(visited.contains(s)) {
                    continue;
                }
                visited.add(s);
                int k = j + 1;
                int l = n - 1;
                while(k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if(sum == target) {
                        result.add(new ArrayList<>());
                        result.get(result.size() - 1).add(nums[i]);
                        result.get(result.size() - 1).add(nums[j]);
                        result.get(result.size() - 1).add(nums[k]);
                        result.get(result.size() - 1).add(nums[l]);
                        k++;
                        l--;
                        while(k < n-1 && nums[k] == nums[k-1]) {
                            k++;
                        }
                        while(l < n-1 && l >= j+1 && nums[l] == nums[l+1]) {
                            l--;
                        }
                    } else {
                        if(sum < target) {
                            k++;
                        } else {
                            l--;
                        }
                    }
                }
            }
        }
        return result;
    }
}
