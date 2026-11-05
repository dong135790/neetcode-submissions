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
        List<ListNode> copy = new ArrayList<>();
        ListNode base = head;
        while (base != null) {
            copy.add(base);
            base = base.next;
        }
        int remove = copy.size() - n;

        if (remove == 0) {
            return head.next;
        }

        copy.get(remove - 1).next = copy.get(remove).next;
        return copy.get(0);
    }
}
