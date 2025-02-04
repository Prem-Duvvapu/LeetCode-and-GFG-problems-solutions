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
    int res;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root==null)
            return 0;

        height(root);
        return res;
    }

    private int height(TreeNode root) {
        if (root==null)
            return 0;

        int leftSubTreeHeight=height(root.left);
        int rightSubTreeHeight=height(root.right);

        res=Math.max(res,leftSubTreeHeight + rightSubTreeHeight);

        return 1+Math.max(leftSubTreeHeight, rightSubTreeHeight);
    }
}