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
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        int lh = calcLeftHeight(root.left);
        int rh = calcRightHeight(root.right);
        if (lh == rh)
            return (1<<(lh+1))-1;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int calcLeftHeight(TreeNode root) {
        int lh = 0;

        while (root!=null) {
            lh++;
            root = root.left;
        }

        return lh;
    }

    private int calcRightHeight(TreeNode root) {
        int rh = 0;

        while (root!=null) {
            rh++;
            root = root.right;
        }

        return rh;
    }
}