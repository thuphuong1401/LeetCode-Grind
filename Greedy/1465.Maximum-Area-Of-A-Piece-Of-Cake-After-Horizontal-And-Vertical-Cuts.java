/*
https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
*/

class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        long MOD = (long)1e9 + 7;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        List<Integer> heights = new ArrayList<>();
        List<Integer> widths = new ArrayList<>();
        
        int maxHeight = -1;
        int n = horizontalCuts.length;
        heights.add(horizontalCuts[0]);
        maxHeight = Math.max(maxHeight, heights.get(0));
        for(int i = 1; i < n; i++) {
            heights.add(horizontalCuts[i] - horizontalCuts[i-1]);
            maxHeight = Math.max(maxHeight, heights.get(heights.size() - 1));
        }
        heights.add(h - horizontalCuts[n-1]);
        maxHeight = Math.max(maxHeight, heights.get(heights.size() - 1));
        
        int maxWidth = -1;
        int m = verticalCuts.length;
        widths.add(verticalCuts[0]);
        maxWidth = Math.max(maxWidth, widths.get(0));
        for(int i = 1; i < m; i++) {
            widths.add(verticalCuts[i] - verticalCuts[i-1]);
            maxWidth = Math.max(maxWidth, widths.get(widths.size() - 1));
        }
        widths.add(w - verticalCuts[m-1]);
        maxWidth = Math.max(maxWidth, widths.get(widths.size() - 1));
        
        long maxArea = (long)maxWidth * (long)maxHeight;
        return (int)(maxArea % MOD);
        
    }
}
