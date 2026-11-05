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

class Solution {

    public void inOrder(TreeNode node, List<Integer> result) {
        if (node == null) return;
        inOrder(node.left, result);
        result.add(node.val);
        inOrder(node.right, result);
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        inOrder(root, result);
        return result.get(k - 1);
    }
}
