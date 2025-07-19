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
        int[] res = {0};
        height(res,root);

        return res[0];
    }

    private int height(int[] res, TreeNode root) {
        if (root == null)
            return 0;

        int leftHeight = height(res,root.left);
        int rightHeight = height(res,root.right);

        res[0] = Math.max(res[0], leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}