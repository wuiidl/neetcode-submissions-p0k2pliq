class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int leftMax = height[l];
        int rightMax = height[r];

        int res = 0;
        while(l < r) {
           if(leftMax < rightMax) {
                l++;
                leftMax = Math.max(height[l], leftMax);
                res += leftMax - height[l];
           }else{
                r--;
                rightMax = Math.max(height[r], rightMax);
                res += rightMax - height[r];
           }
        }
        return res;
    }
}
