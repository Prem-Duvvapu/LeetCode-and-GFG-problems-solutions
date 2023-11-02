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
    int ans=0;
    public int averageOfSubtree(TreeNode root) {
        solve(root);
        return ans;
    }

    private int solve(TreeNode root)
    {
        if (root==null)
            return 0;
            
        int curr=root.val+solve(root.left)+solve(root.right);
        int cnt=NodesCnt(root);
        int avg=(int)Math.round(curr/cnt);
        if (avg==root.val)
            ans++;
        return curr;
    }

    private int NodesCnt(TreeNode root)
    {
        if (root==null)
            return 0;

        int l=NodesCnt(root.left);
        int r=NodesCnt(root.right);
        return 1+l+r;
    }
}