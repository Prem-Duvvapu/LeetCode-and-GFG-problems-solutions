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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();

        if (root==null)
            return res;

        q.add(root);

        while (!q.isEmpty())
        {
            // List<Integer> currLevel=new ArrayList<>();
            int qlen=q.size();
            double n=qlen;
            long sum=0;
            while (qlen-- > 0)
            {
                TreeNode t=q.poll();
                sum+=t.val;
                if (t.left!=null)
                    q.add(t.left);
                if (t.right!=null)
                    q.add(t.right);
            }
            res.add(sum/n);
        }

        return res;
    }
}