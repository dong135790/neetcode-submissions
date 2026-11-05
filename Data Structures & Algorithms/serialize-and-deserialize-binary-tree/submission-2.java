/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current == null) {
                    result.append("N").append(",");
                    continue;
                }
                result.append(current.val).append(",");
                queue.offer(current.left);
                queue.offer(current.right);
            }
        }
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<Integer> tree = new ArrayList<>();
        int left = 0;
        int right = 0;

        // Make string into list for indexing
        while (right < data.length()) {
            if (data.charAt(right) == ',') {
                if (data.charAt(left) == 'N') {
                    tree.add(null);
                } else {
                    tree.add(Integer.parseInt(data.substring(left, right)));
                }
                left = right + 1;
            }
            right++;
        }

        // Now Build the tree from a list
        Queue<TreeNode> parent = new LinkedList<>();
        if (tree.get(0) != null) {
            parent.offer(new TreeNode(tree.get(0)));
        }
        TreeNode output = parent.peek();
        int n = 1;

        while (!parent.isEmpty()) {
            int size = parent.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = parent.poll();

                // if (n == data.length()) break;
                Integer leftN = tree.get(n++);
                Integer rightN = tree.get(n++);

                if (leftN != null) {
                    TreeNode leftNode = new TreeNode(leftN);
                    current.left = leftNode;
                    parent.offer(leftNode);
                }
                if (rightN != null) {
                    TreeNode rightNode = new TreeNode(rightN);
                    current.right = rightNode;
                    parent.offer(rightNode);
                }
            }
        }


        return output;
    }
}
