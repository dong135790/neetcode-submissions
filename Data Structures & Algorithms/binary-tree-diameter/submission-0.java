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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] length = new int[1];
        dfs(root, length);
        return length[0];
    }

    private int dfs(TreeNode root, int[] length) {
        if (root == null) return 0;
        int left = dfs(root.left, length);
        int right = dfs(root.right, length);
        length[0] = Math.max(length[0], left + right);
        return 1 + Math.max(left, right);
    }
}
