class Solution {
    //heights=[2, 1, 5, 6, 2, 3]
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> s = new Stack<>();

        int n = heights.length;

        for(int i = 0; i < n; i++ ) {
            int start = i;
            while(!s.isEmpty() && s.peek()[1] > heights[i]) {
                int[] top = s.pop();
                int index = top[0];
                int height = top[1];
                maxArea = Math.max(maxArea, height * (i - index));
                start = index;
            }
            s.push(new int[]{start, heights[i]});
        }

        for(int[] p : s) {
            int idx = p[0];
            int height = p[1];
            maxArea = Math.max(maxArea, height * (heights.length - idx));
        }

        return maxArea;
    }
}
