/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {

        if(intervals.isEmpty()) return true;

        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        Interval start = intervals.get(0);
        for(int i = 1; i < intervals.size();i++) {
            if(start.end > intervals.get(i).start) return false;
            else start = intervals.get(i);
        }
        return true;
    }
}
