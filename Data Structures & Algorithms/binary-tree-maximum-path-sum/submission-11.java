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
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = root.val;
        dfs(root, max);
        return max[0];
    }

    public int dfs(TreeNode node, int[] max) {
        max[0] = Math.max(max[0], node.val);
        if (node.left == null && node.right == null) {
            return node.val;
        }
        int left = 0, right = 0;
        if (node.left == null) {
            right = dfs(node.right, max);
            if (node.val < right + node.val) {
                max[0] = Math.max(max[0], right + node.val);
                return node.val + right;
            } else {
                return node.val;
            }
        }
        if (node.right == null) {
            left = dfs(node.left, max);
            if (node.val < left + node.val) {
                max[0] = Math.max(max[0], left + node.val);
                return node.val + left;
            } else {
                return node.val;
            }
        }
        if (node.left != null && node.right != null) {
            left = dfs(node.left, max);
            right = dfs(node.right, max);
            max[0] = Math.max(max[0], node.val + left + right);
            max[0] = Math.max(max[0], node.val + left);
            max[0] = Math.max(max[0], node.val + right);

        }
        return node.val + Math.max(0, Math.max(left, right));
    }
}
