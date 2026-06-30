class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> s = new Stack<>();

        for(int i = 0; i < temperatures.length;i++) {
            while(!s.isEmpty() && s.peek()[0] < temperatures[i]){
                int[] item = s.pop();
                res[item[1]] = i - item[1];
            } 
            s.push(new int[]{temperatures[i], i});
        }
        return res;
    }
}
