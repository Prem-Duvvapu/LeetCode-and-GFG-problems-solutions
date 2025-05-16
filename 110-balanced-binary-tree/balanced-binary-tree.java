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
        return (heightAndBalanceCheck(root)!=-1);
    }

    public int heightAndBalanceCheck(TreeNode root) {
        if (root==null)
            return 0;

        int l=heightAndBalanceCheck(root.left);
        if (l==-1)
            return -1;

        int r=heightAndBalanceCheck(root.right);
        if (r==-1)
            return -1;

        int diff=Math.abs(l-r);
        if (diff>1)
            return -1;

        return 1+Math.max(l,r);
    }
}