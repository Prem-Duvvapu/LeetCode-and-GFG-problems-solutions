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
        boolean rightToLeft=false;

        while (!q.isEmpty())
        {
            int qlen=q.size();
            List<Integer> currLevel=new ArrayList<>();
            while (qlen-- > 0)
            {
                TreeNode t=q.poll();
                if (rightToLeft)
                    currLevel.add(0,t.val);
                else
                    currLevel.add(t.val);
                if (t.left!=null)
                    q.add(t.left);
                if (t.right!=null)
                    q.add(t.right);
            }
            
            rightToLeft=!rightToLeft;
            res.add(currLevel);
        }

        return res;
    }
}