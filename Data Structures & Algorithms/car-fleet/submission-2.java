class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pair = new int[position.length][2];
        for(int i = 0; i < position.length;i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }


        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));
        Stack<Double> s = new Stack<>();
        for(int[] p : pair) { // reversed
            // time to target
            s.push((double) (target - p[0]) / p[1]);
            // if we have 2 cars and the top.speed is less than the previous car
            // remove the last item since the car has merged into a fleet
            if(s.size() >= 2 && s.peek() <= s.get(s.size() - 2)) {
                s.pop();
            }
        }
        // size of unique items
        return s.size();
    }
}
