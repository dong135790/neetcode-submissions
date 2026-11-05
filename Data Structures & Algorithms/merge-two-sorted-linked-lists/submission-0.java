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
    ListNode base = new ListNode(0);
    ListNode current = base;
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            current.next = list2;
            return base.next;
        }
        if (list2 == null) {
            current.next = list1;
            return base.next;
        }
        if (list1.val >= list2.val) {
            ListNode temp = new ListNode(list2.val);
            current.next = temp;
            current = current.next;
            mergeTwoLists(list1, list2.next);
        } else {
            ListNode temp = new ListNode(list1.val);
            current.next = temp;
            current = current.next;
            mergeTwoLists(list1.next, list2);
        }
        return base.next;
    }
}