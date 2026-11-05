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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode base = head;
        int size = 0;
        while (base != null) {
            size++;
            base = base.next;
        }
        int delete = size - n;
        base = head;
        if (delete == 0) return head.next;
        ListNode prev = null;
        while (base != null) {
            if (delete == 0) {
                prev.next = base.next;
                break;
            }
            delete--;
            prev = base;
            base = base.next;

        }
        return head;
    }
}
