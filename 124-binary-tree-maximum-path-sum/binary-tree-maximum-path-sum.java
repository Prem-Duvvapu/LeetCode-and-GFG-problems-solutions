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
        int[] maxi=new int[1];
        maxi[0]=Integer.MIN_VALUE;
        solve(root,maxi);
        return maxi[0];
    }

    private int solve(TreeNode root,int[] maxi)
    {
        if (root==null)
            return 0;

        int leftSum=solve(root.left,maxi);
        int rightSum=solve(root.right,maxi);

        maxi[0]=Math.max(maxi[0],root.val+Math.max(0,leftSum)+Math.max(0,rightSum));

        return root.val+Math.max(0,Math.max(leftSum,rightSum));
    }
}