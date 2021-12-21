/*
https://leetcode.com/problems/number-of-ways-to-reorder-array-to-get-same-bst/
*/

class Solution {
    int MOD = (int)1e9 + 7;
    long[][] pascal;

    public int numOfWays(int[] nums) {
        List<Integer> numList = new ArrayList<>();
        for(int num : nums) {
            numList.add(num);
        }
        int n = nums.length;
        pascal = pascalTriangle(n);
        int ans = helper(numList);
        return ans - 1;
    }
    
    private int helper(List<Integer> numList) {
        if(numList.size() <= 2) {
            return 1;
        }
        List<Integer> smaller = new ArrayList<>();
        List<Integer> larger = new ArrayList<>();
        int root = numList.get(0);
        for(int num : numList) {
            if(num < root) {
                smaller.add(num);
            } else if(num > root) {
                larger.add(num);
            }
        }
        int m = smaller.size();
        int n = larger.size();
        
        /*
        C(m + n, m): choose m slots to place all smaller nodes
        helper(smaller): call recursively to determine all the combination within the smaller subtree
        helper(larger): call recursively to determine all the combination within the larger subtree
        */
        long ans = (pascal[m + n][m] * helper(smaller)) % MOD;
        ans = (ans * helper(larger)) % MOD;
        ans %= MOD;
        return (int)ans;
    }
    
    /*
    https://www.mathsisfun.com/pascals-triangle.html
    
    C(n, k) = C(k, n-1) + C(k-1, n-1) => chọn k người, có 2 trường hợp: chọn A hoặc không chọn A
    Suppose we have element A. 
    C(k, n-1): NOT choose A to be included within k other elements
    C(k-1, n-1): choose A to be included within k other elements
    */
    private long[][] pascalTriangle(int n) {
        long[][] triangle = new long[n][n];
        for (int i = 0; i < n; i++) {
            triangle[i][0] = triangle[i][i] = 1;
        }
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                
                // C(n, k) = C(k, n-1) + C(k-1, n-1)
                triangle[i][j] = (triangle[i - 1][j] + triangle[i - 1][j - 1]) % MOD;
            }
        }
        return triangle;
    }
    
    
}
