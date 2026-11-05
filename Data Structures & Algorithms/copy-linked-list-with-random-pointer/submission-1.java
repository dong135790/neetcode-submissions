/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node current = head;
        HashMap<Node, Node> map = new HashMap<>();

        while (current != null) {
            Node node = new Node(current.val);
            map.put(current, node);
            current = current.next;
        }
        current = head;

        while(current != null) {
            Node curr = map.get(current);
            if (map.containsKey(current.next)) {
                curr.next = map.get(current.next);
            }
            if (current.random == null) {
                curr.random = null;
            } else {
                curr.random = map.get(current.random);
            }
            current = current.next;
        }
        return map.get(head);
    }
}
