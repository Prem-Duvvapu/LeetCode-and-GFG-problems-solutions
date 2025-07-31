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
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;

        if (root.val == val)
            return root;

        TreeNode leftSearchResult = searchBST(root.left, val);
        if (leftSearchResult != null)
            return leftSearchResult;

        TreeNode rightSearchResult = searchBST(root.right, val);
        if (rightSearchResult != null)
            return rightSearchResult;

        return null;
    }
}