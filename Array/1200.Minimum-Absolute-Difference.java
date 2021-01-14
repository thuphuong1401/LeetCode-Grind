/*
https://leetcode.com/problems/minimum-absolute-difference/
*/


/*
Why sort? Because when you have an ascendingly sorted array, the min difference between arr[i] and any other number
is arr[i+1], its consecutive element.
*/
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for(int i = 1; i < arr.length; i++) {
            int currDiff = Math.abs(arr[i] - arr[i-1]);
            if(currDiff < minDiff) {
                minDiff = currDiff;
                answer.clear();
                answer.add(new ArrayList<Integer>(Arrays.asList(arr[i-1], arr[i])));
            } else if(currDiff == minDiff) {
                answer.add(new ArrayList<Integer>(Arrays.asList(arr[i-1], arr[i])));
            }
        }
        return answer;
    }
}
