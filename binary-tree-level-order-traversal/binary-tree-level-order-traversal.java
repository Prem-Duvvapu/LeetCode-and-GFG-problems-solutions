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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();

        if (root==null)
            return res;

        q.add(root);

        while (!q.isEmpty())
        {
            List<Integer> curr=new ArrayList<>();
            int qlen=q.size();
            while (qlen-- > 0)
            {
                TreeNode t=q.poll();
                curr.add(t.val);
                if (t.left!=null)
                    q.add(t.left);
                if (t.right!=null)
                    q.add(t.right);
            }
            res.add(curr);
        }

        return res;
    }
}