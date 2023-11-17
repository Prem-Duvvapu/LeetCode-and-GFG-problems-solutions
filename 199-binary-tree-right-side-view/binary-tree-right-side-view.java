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

 //Recursive(revere preorder)
 //Root Right Left
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        reverseInorder(root,0,res);
        return res;
    }

    private void reverseInorder(TreeNode root,int level,List<Integer> res)
    {
        if (root==null)
            return;

        if (level==res.size())
            res.add(root.val);

        reverseInorder(root.right,level+1,res);
        reverseInorder(root.left,level+1,res);
    }
}