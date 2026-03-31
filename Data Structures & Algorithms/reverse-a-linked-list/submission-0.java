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
    public ListNode reverseList(ListNode head) {

        if(head == null) return null;

        ListNode dummy = new ListNode();
        ListNode curr = head;
        while(curr != null) {
            ListNode nextTmp = curr.next;
            insert(curr, dummy);
            curr = nextTmp;
        }
        return dummy.next;
    }

    private void insert(ListNode curr, ListNode dummy) {
        ListNode oldNext = dummy.next;
        dummy.next = curr;
        curr.next = oldNext;
    }
}
