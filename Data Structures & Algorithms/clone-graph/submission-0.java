/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Integer, Node> map = new HashMap<>();
        if (node == null) return null;
        bfs(node, map);
        return map.get(node.val);
    }

    public void bfs(Node node, HashMap<Integer, Node> map) {
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node now = queue.poll();
                if (!map.containsKey(now.val)) {
                    map.put(now.val, new Node(now.val));
                }
                Node current = map.get(now.val);
                for (Node neighbor: now.neighbors) {
                    if (!map.containsKey(neighbor.val)) {
                        map.put(neighbor.val, new Node(neighbor.val));
                        queue.offer(neighbor);
                    }
                    current.neighbors.add(map.get(neighbor.val));
                }
            }
        }
    }
}