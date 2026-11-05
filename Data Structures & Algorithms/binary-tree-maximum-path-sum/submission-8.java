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
            if (right + node.val < node.val) {
                return node.val;
            } else {
                max[0] = Math.max(max[0], right + node.val);
                return right + node.val;
            }
        } else if (node.right == null) {
            left = dfs(node.left, max);
            if (left + node.val < node.val) {
                return node.val;
            } else {
                max[0] = Math.max(max[0], left + node.val);
                return left + node.val;
            }
        } else {
            left = dfs(node.left, max);
            right = dfs(node.right, max);
            // Do we take left, right or all 3?
            int sum = left + right;
            int leftGain = node.val + left;
            int rightGain = node.val + right;

            if (node.val > left + right) {
                max[0] = Math.max(node.val, max[0]);
            }
            max[0] = Math.max(max[0], leftGain);
            max[0] = Math.max(max[0], rightGain);
            max[0] = Math.max(max[0], node.val + sum);

            return node.val + Math.max(0, Math.max(left, right));
        }
    }
}
