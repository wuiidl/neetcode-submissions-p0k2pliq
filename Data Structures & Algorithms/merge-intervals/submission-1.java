class Solution {
    public int[][] merge(int[][] intervals) {

        if(intervals.length <= 1) return intervals;
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] start = intervals[0];
        for(int i = 1; i < intervals.length;i++) {
            int[] curr = intervals[i];
            if(start[1] >= curr[0]) {
                // merge
                start[0] = Math.min(curr[0], start[0]);
                start[1] = Math.max(curr[1], start[1]);
            } else {
                res.add(new int[] {start[0], start[1]});
                start = curr;
            }
            
        }
        res.add(new int[] { start[0], start[1] });
        return res.toArray(new int[res.size()][]);
    }
}
