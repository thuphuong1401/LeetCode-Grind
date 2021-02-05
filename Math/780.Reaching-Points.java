/*
https://leetcode.com/problems/reaching-points/
*/


/*
Big idea: since travel from source to target will give TLE (tree has 2^n nodes), we travel from target back to source (only 1 path exists, therefore complexity ~O(logN)
=> We need to repeatedly subtract the bigger of the two (tx, ty) from each other and see if we can ever reach (sx, sy)

Optimization: we observe the following:
(x,y) transform in 2 ways: (x + y, y) or (x, x + y).
k transformations in 1st method gives (x + ky, y)
k transformations in 2nd method gives (x, kx + y)
=> tx = (sx + k*sy) and ty = (k*sx + sy)
=> k = (tx - sx)/sy and k = (ty - sy)/sx
which also means (tx - sx)%sy = 0 and (ty - sy)%sx = 0
*/

class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while(sx < tx && sy < ty) {
            if(tx > ty) {
                tx %= ty;
            } else {
                ty %= tx;
            }
        }
        
        if(sx == tx && sy <= ty && (ty - sy) % sx == 0) {
            return true;
        }
        
        return (sy == ty && sx <= tx && (tx - sx) % sy == 0);
    }
}
