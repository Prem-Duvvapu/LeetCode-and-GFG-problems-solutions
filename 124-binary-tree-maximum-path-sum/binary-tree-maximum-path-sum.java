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
        int[] res = {-Integer.MIN_VALUE};
        helper(res, root);

        return res[0];
    }

    private int helper(int[] res, TreeNode root) {
        if (root == null)
            return 0;

        int leftSum = Math.max(0, helper(res, root.left));
        int rightSum = Math.max(0, helper(res, root.right));

        res[0] = Math.max(res[0], root.val + leftSum + rightSum);

        return root.val + Math.max(leftSum, rightSum);
    }
}