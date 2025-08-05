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
class BSTIterator {
    private Stack<TreeNode> stack;
    private boolean reverse;

    public BSTIterator(TreeNode root,boolean reverse) {
        stack = new Stack<>();
        this.reverse = reverse;

        if (reverse)
            pushAllRightNodes(root);
        else
            pushAllLeftNodes(root);
    }

    public int next() {
        TreeNode temp = stack.pop();
        pushAllLeftNodes(temp.right);
        return temp.val;
    }

    public int before() {
        TreeNode temp = stack.pop();
        pushAllRightNodes(temp.left);
        return temp.val;
    }

    private void pushAllLeftNodes(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
    }

    private void pushAllRightNodes(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            stack.push(curr);
            curr = curr.right;
        }
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator iterator = new BSTIterator(root, false);
        BSTIterator iterator2 = new BSTIterator(root, true);

        int i = iterator.next();
        int j = iterator2.before();
        
        while (i<j) {
            if (i+j < k) {
                i = iterator.next();
            } else if (i+j > k) {
                j = iterator2.before();
            } else {
                return true;
            }
        }

        return false;
    }
}