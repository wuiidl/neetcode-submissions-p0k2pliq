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
        // (5,10), (15,20), (0, 30)

        PriorityQueue<Interval> q = new PriorityQueue<>((a, b) -> Integer.compare(a.end, b.end));
        for(Interval i : intervals) {
            q.offer(i);
        }

        Interval start = q.poll();
        while(!q.isEmpty()) {
            Interval next = q.poll();
            if(start.end > next.start) return false;
            else start = next;
        }

        return true;
    }
}
