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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = head;
        int current = 0;
        while (dummy != null && current < k) {
            current++;
            dummy = dummy.next;
        }

        if (current == k) {
            ListNode prev = reverseKGroup(dummy, k);
            while (current > 0) {
                ListNode tmp = head.next;
                head.next = prev;
                prev = head;
                head = tmp;
                current--;
            }
            head = prev;
        }
        return head;
    }
}
