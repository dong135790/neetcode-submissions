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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> first = new LinkedList<>();
        Queue<TreeNode> second = new LinkedList<>();

        first.offer(p);
        second.offer(q);
        int level = 0;
        while (!first.isEmpty() && !second.isEmpty()) {
            int size = first.size();
            for (int i = 0; i < size; i++) {
                TreeNode one = first.poll();
                TreeNode two = second.poll();
                
                if (one == null && two == null) continue;
                if (one == null || two == null) return false;
                if (one.val != two.val) return false;

                first.offer(one.left);
                first.offer(one.right);
                second.offer(two.left);
                second.offer(two.right);
            }
        }
        return true;
    }
}
// 2 3
// 2 3