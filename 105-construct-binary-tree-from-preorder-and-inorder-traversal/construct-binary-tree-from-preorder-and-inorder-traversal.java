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
        int n = inorder.length;
        Map<Integer,Integer> map = new HashMap<>();

        for (int i=0;i<n;i++)
            map.put(inorder[i],i);

        return solve(preorder,0,n-1,inorder,0,n-1,map);
    }

    private TreeNode solve(int[] preOrder,int preStart,int preEnd,int[] inOrder,int inStart,int inEnd,Map<Integer,Integer> map) {
        if (inStart > inEnd || preStart > preEnd)
            return null;

        int rootPos = map.get(preOrder[preStart]);
        TreeNode root = new TreeNode(inOrder[rootPos]);
        root.left = solve(preOrder,preStart+1,preStart+(rootPos-inStart),inOrder,inStart,rootPos-1,map);
        root.right = solve(preOrder,preStart+(rootPos-inStart)+1,preEnd,inOrder,rootPos+1,inEnd,map);

        return root;
    }
}