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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // If fast is at end, middle is slow.next
        ListNode second = slow.next;
        ListNode prev = slow.next = null;
        // Now reverse 2nd half of list
        while (second != null) {
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        ListNode left = head;
        ListNode right = prev;
        while (right != null) {
            ListNode temp1 = left.next;
            ListNode temp2 = right.next;
            left.next = right;
            right.next = temp1;
            left = temp1;
            right = temp2;
        }
    }
}
