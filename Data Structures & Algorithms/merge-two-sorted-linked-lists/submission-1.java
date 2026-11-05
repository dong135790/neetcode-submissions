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
        ListNode base = new ListNode(0);
        ListNode current = base;
        while (list1 != null && list2 != null) {
            int val1 = list1.val;
            int val2 = list2.val;
            if (val1 > val2) {
                ListNode node = new ListNode(val2);
                current.next = node;
                list2 = list2.next;
            } else {
                ListNode node = new ListNode(val1);
                current.next = node;
                list1 = list1.next;
            }
            current = current.next;
        }
        if (list1 == null) {
            current.next = list2;
        } else {
            current.next = list1;
        }
        return base.next;
    }
}