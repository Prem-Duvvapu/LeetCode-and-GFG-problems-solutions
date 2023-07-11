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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if (root==null)
            return res;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int k=0;

        while (!q.isEmpty())
        {
            List<Integer> currLevel=new ArrayList<>();
            int qlen=q.size();
            while (qlen-- > 0)
            {
                TreeNode t=q.poll();
                currLevel.add(t.val);
                if (t.left!=null)
                    q.add(t.left);
                if (t.right!=null)
                    q.add(t.right);
            }
            if (k++%2==1)
                Collections.reverse(currLevel);
            res.add(currLevel);
        }

        return res;
    }
}