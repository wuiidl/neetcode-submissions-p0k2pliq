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

        if(list1 == null) return list2;
        if(list2 == null) return list1;

        List<Integer> nodes = new ArrayList<>();
        
        flatten(list1, nodes);
        flatten(list2, nodes);      
        Collections.sort(nodes);

        ListNode head = new ListNode();
        ListNode next = new ListNode(nodes.get(0));
        head.next = next;
        for(int i = 1; i < nodes.size();i++) {
            ListNode tmp = new ListNode(nodes.get(i));
            next.next = tmp;
            next = tmp;
        }

        return head.next;
    }

    private void flatten(ListNode l, List<Integer> nodes) {
        ListNode curr = l;
        while(curr != null) {
            nodes.add(curr.val);
            curr = curr.next;
        }
    }

}