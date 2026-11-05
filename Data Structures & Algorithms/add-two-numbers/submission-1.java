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
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();

        while (l1 != null) {
            first.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            second.add(l2.val);
            l2 = l2.next;
        }
        List<Integer> sum = new ArrayList<>();
        if (first.size() < second.size()) {
            List<Integer> copy = new ArrayList<>(first);
            first = second;
            second = copy;
        }    
        int carry = 0;
        for (int i = 0; i < first.size(); i++) {
            int current = first.get(i) + carry;

            if (i < second.size()) {
                current += second.get(i);
            }
            int digit = current % 10;
            carry = current / 10;
            sum.add(digit);
        }
        if (carry > 0) {
            sum.add(carry);
        }

        ListNode base = new ListNode(0);
        ListNode pointer = base;
        for (int i = 0; i < sum.size(); i++) {
            ListNode node = new ListNode(sum.get(i));
            pointer.next = node;
            pointer = pointer.next;
        }
        return base.next;
    }
}
