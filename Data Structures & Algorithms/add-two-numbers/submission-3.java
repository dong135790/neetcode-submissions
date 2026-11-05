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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode base = new ListNode();
        ListNode current = base;
        ArrayList<Integer> sumList = new ArrayList<>();
        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null && l2 != null) {
                sum = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 == null) {
                sum = l2.val + carry;
                l2 = l2.next;
            } else {
                sum = l1.val + carry;
                l1 = l1.next;
            }
            int digit = sum % 10;
            carry = sum / 10;
            sumList.add(digit);
        }
        if (carry > 0) {
            sumList.add(carry);
        }
        for (int i = 0; i < sumList.size(); i++) {
            ListNode node = new ListNode(sumList.get(i));
            current.next = node;
            current = current.next;
        }
        return base.next;
    }
}
