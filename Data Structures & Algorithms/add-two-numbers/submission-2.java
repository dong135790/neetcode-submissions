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
        ListNode base = new ListNode(0);
        ArrayList<Integer> one = new ArrayList<>();
        ArrayList<Integer> two = new ArrayList<>();

        while (l1 != null) {
            one.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            two.add(l2.val);
            l2 = l2.next;
        }

        if (one.size() < two.size()) {
            ArrayList<Integer> tmp = new ArrayList<>(one);
            one = two;
            two = tmp;
        }

        ArrayList<Integer> sum = new ArrayList<>();
        int carry = 0;
        for (int i = 0; i < one.size(); i++) {
            int current = one.get(i) + carry;
            if (i < two.size()) {
                current += two.get(i);
            }
            int digit = current % 10;
            carry = current / 10;
            sum.add(digit);
        }
        if (carry > 0) {
            sum.add(carry);
        }

        ListNode cur = base;
        for (int i = 0; i < sum.size(); i++) {
            ListNode node = new ListNode(sum.get(i));
            cur.next = node;
            cur = cur.next;
        }
        return base.next;
    }
}
