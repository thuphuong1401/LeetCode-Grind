/*
https://leetcode.com/problems/first-bad-version/
*/

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

/*
My implementation
*/
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if(n == 1) {
            return 1;
        }
        int low = 0;
        int high = n;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(mid == 0 || (isBadVersion(mid) && !isBadVersion(mid-1))) {
                if(mid == 0) {
                    return mid+1;
                }
                return mid;
            } 
            
            if(isBadVersion(mid)) {
                high = mid-1;
            } else {
                low = mid+1;
            }
            
        }
        
        return -1;
    }
}
