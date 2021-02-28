/*
https://leetcode.com/problems/how-many-apples-can-you-put-into-the-basket/
*/

class Solution {
    public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int count = 0;
        int weight = 5000;
        for(int i = 0; i < arr.length; i++) {
            if(weight - arr[i] >= 0) {
                weight -= arr[i];
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
