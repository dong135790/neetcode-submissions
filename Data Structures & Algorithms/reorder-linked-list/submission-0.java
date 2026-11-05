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
        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode copy = head;
        int index = 0;
        while (copy != null) {
            map.put(index++, copy.val);
            copy = copy.next;
        }
        int size = index;
        index = 1;
        int idx = 1;
        while (index < size) {
            if (index % 2 == 1) {
                head.next = new ListNode(map.get(size - idx));
            } else {
                head.next = new ListNode(map.get(idx++));
            }
            head = head.next;
            index++;
        }
    }
}
