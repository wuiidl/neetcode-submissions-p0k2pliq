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
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(Interval i : intervals) {
            if(!q.isEmpty() && q.peek() <= i.start) {
                q.poll();
            }
            q.offer(i.end);
        }
        return q.size();
    }  
}
