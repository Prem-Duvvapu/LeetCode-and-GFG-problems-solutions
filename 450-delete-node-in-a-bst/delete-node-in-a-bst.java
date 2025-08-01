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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        if (root.val == key)
            return helper(root);

        TreeNode curr = root;
        while (curr != null) {
            if (key < curr.val) {
                if (curr.left != null && curr.left.val == key) {
                    curr.left = helper(curr.left);
                    break;
                } else {
                    curr = curr.left;
                }
            } else if (key > curr.val) {
                if (curr.right != null && curr.right.val == key) {
                    curr.right = helper(curr.right);
                    break;
                } else {
                    curr = curr.right;
                }
            }
        }

        return root;
    }

    private TreeNode helper(TreeNode root) {
        if (root.left == null)
            return root.right;

        if (root.right == null)
            return root.left;

        TreeNode rightSubTree = root.right;
        TreeNode leftSubTreeLastRight = findLastRight(root.left);
        leftSubTreeLastRight.right = rightSubTree;
        return root.left;
    }

    private TreeNode findLastRight(TreeNode root) {
        while (root.right != null)
            root = root.right;

        return root;
    }
}