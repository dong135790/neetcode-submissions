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
    int prev = 0;
    boolean flag = true;

    public void inOrder(TreeNode root, List<Integer> order) {
        if (root == null) return;
        if (flag == false) return;

        inOrder(root.left, order);
        // System.out.println("Prev: " + order.get(prev) + " Current: " + root.val);
        if (order.get(prev) < root.val) {
            prev++;
            order.add(root.val);
        } else {
            flag = false;
        }
        inOrder(root.right, order);
    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> order = new ArrayList<>();
        order.add(Integer.MIN_VALUE);
        inOrder(root, order);
        return flag;
    }
}
