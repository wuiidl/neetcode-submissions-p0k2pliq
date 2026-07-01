class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];

        Stack<int[]> pairs = new Stack<>();
        for(int i = 0; i < n;i++) {
            // get current temp
            int t = temperatures[i];
            while(!pairs.isEmpty() && t > pairs.peek()[0]) {
                int[] p = pairs.pop();
                result[p[1]] = i - p[1];
            }
            pairs.push(new int[]{t, i});
        }
        return result;
    }
}
