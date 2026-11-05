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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // What if root == null? can this even happen? No

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        // This is the case for descendants (not oneself)
        if (root.val < q.val && root.val > p.val ||
            root.val < p.val && root.val > q.val) {
            return root;
        }
        // Both nodes are greater than current
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // Both nodes are less than current
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return null;
    }
}
