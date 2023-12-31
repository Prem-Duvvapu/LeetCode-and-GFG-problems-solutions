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
    int res=0;
    int cnt;
    public int kthSmallest(TreeNode root, int k) {
        cnt=k;
        inorder(root);
        return res;
    }

    private void inorder(TreeNode root)
    {
        if (root==null)
            return;

        inorder(root.left);
        if (--cnt == 0)
            res=root.val;
        inorder(root.right);
    }
}