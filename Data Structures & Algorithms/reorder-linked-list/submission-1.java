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
        List<ListNode> copy = new ArrayList<>();
        ListNode base = head;
        while (base != null) {
            copy.add(base);
            base = base.next;
        }
        int i = 1, j = copy.size() - 1;
        while (i <= j) {
            head.next = copy.get(j);
            j--;
            head = head.next;
            if (i > j) break;
            head.next = copy.get(i);
            i++;
            head = head.next;
        }
        head.next = null;
    }
}
