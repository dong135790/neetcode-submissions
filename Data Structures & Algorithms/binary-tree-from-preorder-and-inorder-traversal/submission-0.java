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
    HashMap<Integer, Integer> map = new HashMap<>();
    int index = 0;

    public TreeNode dfs(int[] preorder, int left, int right) {
        if (left > right) return null;
        int value = preorder[index++];
        int mid = map.get(value);
        TreeNode node = new TreeNode(value);
        node.left = dfs(preorder, left, mid - 1);
        node.right = dfs(preorder, mid + 1, right);
        return node;

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, 0, inorder.length - 1);
    }
}
