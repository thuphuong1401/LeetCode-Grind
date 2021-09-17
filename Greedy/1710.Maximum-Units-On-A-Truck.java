/*
https://leetcode.com/problems/maximum-units-on-a-truck/
*/
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (b1, b2) -> Integer.compare(b2[1], b1[1]));
        int numUnits = 0;
        int i = 0;
        int n = boxTypes.length;
        while(i < n && truckSize > 0) {
            int[] currBox = boxTypes[i];
            int num = currBox[0];
            int units = currBox[1];
            while(num > 0) {
                num--;
                numUnits += units;
                truckSize--;
                if(truckSize == 0) {
                    break;
                }
            }
            i++;
        }
        return numUnits;
    }
}
