class Solution {
    public int trap(int[] height) {
        int maxL = -1;
        int maxR = -1;
        int l = 0;
        int r = height.length - 1;

        int res = 0;

        while(l < r) {
            maxL = Math.max(height[l], maxL);
            maxR = Math.max(height[r], maxR);
            res += maxL - height[l];
            res += maxR - height[r];

            if(height[l] < height[r]) {
                l++;
            }else{
                r--;
            }
        }
        return res;
    }
}
