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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=inorder.length;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<n;i++)
            map.put(inorder[i],i);

        return solve(inorder,0,n-1,postorder,0,n-1,map);
    }

    private TreeNode solve(int[] inorder,int inStart,int inEnd,int[] postorder,int postStart,int postEnd,Map<Integer,Integer> map)
    {
        if (inStart>inEnd || postStart>postEnd)
            return null;
            
        TreeNode root=new TreeNode(postorder[postEnd]);
        int pos=map.get(postorder[postEnd]);
        root.right=solve(inorder,pos+1,inEnd,postorder,postEnd-(inEnd-pos),postEnd-1,map);
        root.left=solve(inorder,inStart,pos-1,postorder,postStart,postEnd-(inEnd-pos)-1,map);
        return root;
    }
}