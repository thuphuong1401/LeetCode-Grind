/*
https://leetcode.com/problems/permutation-sequence/
*/

class Solution {
    // how to generate a permuatation
    public String getPermutation(int n, int k) {
        --k;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add((i+1));
        }
        int[] arr = new int[n];
        
        int[] factorial = new int[n+1];
        factorial[0] = 1;
        for(int i = 1; i <= n; i++) {
            factorial[i] = factorial[i-1] * i;
        }
        
        int firstIndex = k / factorial[n-1];
        arr[0] = list.get(firstIndex);
        list.remove(firstIndex);
       
        for(int i = 1; i < n; i++) {
            int index = (int)Math.floor(k % factorial[n-i]) / factorial[n-i-1];
            arr[i] = list.get(index);
            list.remove(index);
        }
        StringBuilder sb = new StringBuilder();
        for(int num : arr) {
            sb.append(Integer.toString(num));
        }
        return sb.toString();
    }
    
}

/*
floor(k / (n-1)!)

index2 = floor(k % (n-1)!) / (n-2)! 
sap xep tat ca (n-1) so con lai tu be den lon


index = floor(k % (n-i)!) / (n-i-1)!

9
0 - based

k = 9 => tinh la 8
index1 = 1; {1, 2, 3, 4}, dien 2
index2 = floor(9 % (4-1)!) / (4-2)!
        = floor(2 / 2!) = 1 => 2nd pos = 3 {1, 3, 4}, dien arr[1] = 3
index3 = floor(8 % (4-2)!) / (4-3)!
        = floor(0 / 1) = 0 => {1, 4} 2nd pos = 1  

    
    
n = 4; k = 6;
index1 = floor(6 / (4-1)!) 
       = floor(6 / 3!) = 1 
    
n
- - - - - -
/*
n = 4
1.  1234
2.  1243
3.  1324
4.  1342
5.  1423
6.  1432


7.  2134
8.  2143                           
9.  2314
10. 2341
11. 2413
12. 2431


13. 3124

*/    
