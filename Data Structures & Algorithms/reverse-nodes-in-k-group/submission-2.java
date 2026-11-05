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
        HashMap<Integer, ListNode> map = new HashMap<>();
        int i = 1;
        while (head != null) {
            map.put(i++, head);
            head = head.next;
        }
        int size = map.size();
        for (int start = 1; start + k - 1 <= size; start += k) {
            int end = start + k - 1;
            int current = end;
            while (current > start) {
                map.get(current--).next = map.get(current);
            }

            if (end < size) {
                if (end + k <= size) {
                    map.get(start).next = map.get(end + k);
                } else {
                    map.get(start).next = map.get(end + 1);
                }
            } else {
                map.get(start).next = null;
            }
        }
        return map.get(k);
    }
}
