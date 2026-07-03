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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode head = new ListNode(0);
        ListNode next = head; // points to the end

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                next.next = list1;
                list1 = list1.next;
            } else {
                next.next = list2;
                list2 = list2.next;
            }
            next = next.next;
        }
        if (list1 != null) {
            next.next = list1;
        } else {
            next.next = list2;
        }
        return head.next;
    }
}