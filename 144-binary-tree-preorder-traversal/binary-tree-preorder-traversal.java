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

 //Recursive
 //Root Left Right
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        solve(root,res);
        return res;
    }

    private void solve(TreeNode root,List<Integer> res)
    {
        if (root==null)
            return;

        res.add(root.val);
        solve(root.left,res);
        solve(root.right,res);
    }
}