class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] pairs = new int[n][2];

        for(int i = 0; i < n;i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }

        // from back to front
        Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));

        Stack<Double> s = new Stack<>();

        for(int i = 0; i < n;i++) {
            int[] p = pairs[i];
            // add the ETA
            s.push((double) (target - p[0]) / p[1]);
            if(s.size() >= 2 && s.get(s.size() - 2) >= s.peek()) {
                s.pop();
            }
        }
        return s.size();
    }
}
