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
    public String tree2str(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        solve(root,sb);
        return sb.toString();
    }

    private void solve(TreeNode root,StringBuilder sb)
    {
        if (root==null)
            return;

        if (isLeaf(root))
        {
            sb.append(root.val);
            return;
        }

        sb.append(root.val);
        sb.append("(");
        solve(root.left,sb);
        sb.append(")");

        if (root.right==null)
            return;
        sb.append("(");
        solve(root.right,sb);
        sb.append(")");
    }

    private boolean isLeaf(TreeNode root)
    {
        return (root!=null && root.left==null && root.right==null);
    }
}