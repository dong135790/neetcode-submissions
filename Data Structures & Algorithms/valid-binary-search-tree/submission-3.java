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
    int prev = -1000000001;
    boolean flag = true;

    public void inOrder(TreeNode root) {
        if (root == null) return;
        if (flag == false) return;

        inOrder(root.left);
        if (prev < root.val) {
            prev = root.val;
        } else {
            flag = false;
        }
        inOrder(root.right);
    }

    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        return flag;
    }
}
