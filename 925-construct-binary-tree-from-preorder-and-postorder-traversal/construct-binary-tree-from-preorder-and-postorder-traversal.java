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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return solve(preorder,0,preorder.length-1,postorder,0,postorder.length-1);
    }

    public TreeNode solve(int[] preorder,int preStart,int preEnd,int[] postorder,int postStart,int postEnd) {
        if (preStart>preEnd || postStart>postEnd)
            return null;

        TreeNode root=new TreeNode(preorder[preStart]);

        int leftRootIndex=postEnd-1;
        while (leftRootIndex>postStart && preStart+1<preorder.length-1 && postorder[leftRootIndex]!=preorder[preStart+1])
            leftRootIndex--;
        
        root.left=solve(preorder,preStart+1,preStart+1+(leftRootIndex-postStart),postorder,postStart,leftRootIndex);
        root.right=solve(preorder,preStart+2+(leftRootIndex-postStart),preEnd,postorder,leftRootIndex+1,postEnd-1);

        return root;
    }
}