class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int res = 0;
        int prevEnd;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if(prevEnd <= start) {
                // no overlap
                prevEnd = end;
            } else {
                res++;
                prevEnd = Math.min(prevEnd, end);
            }

        }
        return res;
    }
}
