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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=inorder.length;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<n;i++)
            map.put(inorder[i],i);

        return solve(inorder,0,n-1,preorder,0,n-1,map);
    }

    private TreeNode solve(int[] inorder,int inStart,int inEnd,int[] preOrder,int preStart,int preEnd,Map<Integer,Integer> map)
    {
        if (inStart>inEnd || preStart>preEnd)
            return null;

        TreeNode root=new TreeNode(preOrder[preStart]);
        int pos=map.get(root.val);
        root.left=solve(inorder,inStart,pos-1,preOrder,preStart+1,preStart+pos-inStart,map);
        root.right=solve(inorder,pos+1,inEnd,preOrder,preStart+pos-inStart+1,preEnd,map);
        return root;
    }
}