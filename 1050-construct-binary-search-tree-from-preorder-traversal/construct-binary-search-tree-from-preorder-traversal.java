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
        return solve(new int[]{0}, 1001, preorder);
    }

    private TreeNode solve(int[] pos, int upperBound, int[] preorder) {
        if (pos[0] == preorder.length || preorder[pos[0]] > upperBound)
            return null;

        TreeNode root = new TreeNode(preorder[pos[0]]);
        pos[0]++;

        root.left = solve(pos, root.val, preorder);
        root.right = solve(pos, upperBound, preorder);

        return root;
    }
}