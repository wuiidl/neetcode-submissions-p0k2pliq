class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int[] start = intervals[0];

        for(int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
            if(next[0] <= start[1]) {
                start[1] = Math.max(start[1], next[1]);
            } else {
                result.add(start);
                start = next;
            }
        }
        result.add(start);
        return result.toArray(new int[0][]);
    }
}
