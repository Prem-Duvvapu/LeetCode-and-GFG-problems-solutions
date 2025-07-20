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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode lastNode = q.peekLast();
            res.add(lastNode.val);

            int qlen = q.size();

            while (qlen-- > 0) {
                TreeNode currNode = q.poll();

                if (currNode.left!=null)
                    q.add(currNode.left);

                if (currNode.right!=null)
                    q.add(currNode.right);
            }
        }

        return res;
    }
}