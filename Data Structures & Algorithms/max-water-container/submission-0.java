class Solution {
    public int maxArea(int[] heights) {
        int max = -1;
        int maxArea = -1;
        int l = 0;
        int r = heights.length - 1;

        while(l < r) {
            int minHeight = Math.min(heights[l], heights[r]);
            int length = r - l;
            maxArea = Math.max(maxArea, length * minHeight);
            if(heights[l] < heights[r]) {
                l++;
            }else{
                r--;
            }
        }
        return maxArea;
    }
}
