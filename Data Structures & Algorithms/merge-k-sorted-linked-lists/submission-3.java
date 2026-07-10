/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> q = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        for(ListNode l : lists) {
            q.offer(l);
        }


        ListNode dummy = new ListNode();
        ListNode head = dummy;

        while(!q.isEmpty()) {
            ListNode n = q.poll();
            head.next = n;
            head = head.next;
            if(n.next != null) q.offer(n.next);
        }
        return dummy.next;
    }
}
