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
    public TreeNode bstFromPreorder(int[] preorder) {
        return solve(preorder,Integer.MAX_VALUE,new int[]{0});
    }

    private TreeNode solve(int[] a,int upperBound,int[] i)
    {
        if (i[0]==a.length || a[i[0]]>upperBound)
            return null;

        TreeNode root=new TreeNode(a[i[0]++]);
        root.left=solve(a,root.val,i);
        root.right=solve(a,upperBound,i);

        return root;
    }
}