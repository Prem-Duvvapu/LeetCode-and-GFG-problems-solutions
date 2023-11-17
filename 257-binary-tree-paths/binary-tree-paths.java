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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res=new ArrayList<>();
        if (root.left==null && root.right==null)
            res.add(""+root.val);
        solve(root.left,""+root.val,res);
        solve(root.right,""+root.val,res);
        return res;
    }

    private void solve(TreeNode root,String curr,List<String> res)
    {
        if (root==null)
            return;

        curr=curr+"->"+root.val;
        solve(root.left,curr,res);
        solve(root.right,curr,res);
        if (root.left==null && root.right==null)
            res.add(curr);
    }
}