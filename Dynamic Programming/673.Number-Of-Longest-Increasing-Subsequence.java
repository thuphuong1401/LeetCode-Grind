/*
https://leetcode.com/problems/number-of-longest-increasing-subsequence/
*/

/*
O(n^2) solution
*/
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] count = new int[n];
        Arrays.fill(count, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    count[i] = count[j];
                } else if (nums[i] > nums[j] && dp[j] + 1 == dp[i]) {
                    count[i] += count[j];
                }
            }
        }

        int maxLength = 0;
        int countMaxLength = 0;
        for (int i = 0; i < n; i++) {
            if (maxLength < dp[i]) {
                maxLength = dp[i];
                countMaxLength = count[i];
            } else if (maxLength == dp[i]) {
                countMaxLength += count[i];
            }
        }
        return countMaxLength;
    }
}




/*
O(nlogn) solution
*/
class Solution {
    public int findNumberOfLIS(int[] arr) {
        List<TreeMap<Integer, Integer>> dp = new ArrayList<>();
        int length = 1;
        int n = arr.length;
        for(int i = 0; i <= n; i++) {
            dp.add(new TreeMap<>());
        }
        List<Integer> result = new ArrayList<>();
        result.add(0);
        dp.get(1).put(arr[0], 1);
        for(int i = 1; i < n; i++) {
            if(arr[i] < arr[result.get(0)]) {
                result.set(0, i);
                dp.get(1).put(arr[i], 1);
            } else if (arr[i] == arr[result.get(0)]) {
                dp.get(1).put(arr[i], dp.get(1).get(arr[i]) + 1);
            } else if(arr[i] > arr[result.get(length - 1)]) {
                result.add(i);
                length++;
                TreeMap<Integer, Integer> temp = dp.get(length - 1);
                int count = 0;
                for(Map.Entry<Integer, Integer> entry : temp.entrySet()) {
                    if(entry.getKey() < arr[i]) {
                        count += entry.getValue();
                    }
                }
                dp.get(length).put(arr[i], count);
            } else {
                int pos = lowerBound(arr, result, length, arr[i]);
                
                int count = 0;
                TreeMap<Integer, Integer> temp = dp.get(pos);
                for(Map.Entry<Integer, Integer> entry : temp.entrySet()) {
                    if(entry.getKey() < arr[i]) {
                        count += entry.getValue();
                    }
                }
                
                if(dp.get(pos+1).containsKey(arr[i])) {
                    count += dp.get(pos + 1).get(arr[i]);
                }
                dp.get(pos + 1).put(arr[i], count);
                
                result.set(pos, i);
            }
        }
        
        
        TreeMap<Integer, Integer> tempMap = dp.get(length);
        int ans = 0;
        for(Map.Entry<Integer, Integer> entry : tempMap.entrySet()) {
            ans += entry.getValue();
        }
        
        return ans;
        
    }
    
    private static int lowerBound(int[] arr, List<Integer> result, int n, int x) {
        int low = 0; 
        int high = n;
        int pos = n;
        while(low < high) {
            int mid = low + (high - low)/2;
            int index = result.get(mid);
            if(arr[index] >= x)  {
                pos = mid;
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return pos;
    }

}
