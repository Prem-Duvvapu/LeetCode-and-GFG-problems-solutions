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
    private boolean checkBST(TreeNode root,long minVal,long maxVal)
    {
        if (root==null)
            return true;

        if (root.val<=minVal || root.val>=maxVal)
            return false;

        boolean checkLeft=checkBST(root.left,minVal,root.val);
        boolean checkRight=checkBST(root.right,root.val,maxVal);

        return (checkLeft && checkRight);
    }

    public boolean isValidBST(TreeNode root) {
        return checkBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
}