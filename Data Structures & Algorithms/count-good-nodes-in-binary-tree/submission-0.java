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
    public int goodNodes(TreeNode root) {
        int max = -101;
        int[] good = new int[1];
        dfs(root, max, good);
        return good[0];
    }

    public void dfs(TreeNode node, int max, int[] good) {
        if (node == null) return;

        if (node.val >= max) {
            good[0]++;
        }
        max = Math.max(node.val, max);
        dfs(node.left, max, good);
        dfs(node.right, max, good);

        return;
    }
}
