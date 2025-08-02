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
    int cnt;
    int res;
    public int kthSmallest(TreeNode root, int k) {
        cnt = k;
        inOrder(root);
        return res;
    }

    public void inOrder(TreeNode root) {
        if (root == null)
            return;

        inOrder(root.left);
        cnt--;
        if (cnt == 0) {
            res = root.val;
            return;
        }
        inOrder(root.right);
    }
}