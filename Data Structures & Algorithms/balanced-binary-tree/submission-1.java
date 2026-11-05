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
    public boolean isBalanced(TreeNode root) {
        // Figure out height on left and right on every node, take difference and store that 
        int[] diff = new int[1];
        dfs(root, diff);
        return diff[0] <= 1;
    }

    private int dfs(TreeNode root, int[] diff) {
        if (root == null) return 0;

        int left = dfs(root.left, diff);
        int right = dfs(root.right, diff);
        diff[0] = Math.max(diff[0], Math.abs(left - right));
        return 1 + Math.max(left, right);
    }
}
