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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q=new ArrayDeque<>();
        q.add(root);
        int res=0;

        while (!q.isEmpty()) {
            res=q.peek().val;
            int qlen=q.size();

            while (qlen-- > 0) {
                TreeNode curr=q.poll();
                if (curr.left!=null)
                    q.add(curr.left);
                
                if (curr.right!=null)
                    q.add(curr.right);
            }
        }

        return res;
    }
}