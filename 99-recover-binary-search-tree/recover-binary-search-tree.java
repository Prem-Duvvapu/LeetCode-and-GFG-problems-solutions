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
    TreeNode prev,first,last;

    public void recoverTree(TreeNode root) {
        first=last=prev=null;

        inorder(root);
        
        int temp=first.val;
        first.val=last.val;
        last.val=temp;
    }

    private void inorder(TreeNode root)
    {
        if (root==null)
            return;

        inorder(root.left);

        if (prev!=null && root.val<prev.val)
        {
            if (first==null)
            {
                first=prev;
                last=root;
            }
            else
                last=root;
        }
        prev=root;

        inorder(root.right);
    }
}