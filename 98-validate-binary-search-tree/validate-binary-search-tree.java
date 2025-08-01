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
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode root, long minVal, long maxVal) {
        if (root == null)
            return true;

        long currVal = (long)root.val;
        if (currVal < minVal || currVal > maxVal)
            return false;

        boolean leftCheck = helper(root.left, minVal, currVal-1);
        boolean rightCheck = helper(root.right, currVal+1, maxVal);

        return (leftCheck && rightCheck);
    }
}