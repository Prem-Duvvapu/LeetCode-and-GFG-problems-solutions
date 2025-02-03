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
        Queue<TreeNode> q=new ArrayDeque<>();

        if (root==null)
            return res;

        q.add(root);

        while (!q.isEmpty()) {
            int len=q.size();
            List<Integer> currList=new ArrayList<>();

            while (len-- > 0) {
                TreeNode curr=q.poll();
                currList.add(curr.val);

                if (curr.left!=null)
                    q.add(curr.left);

                if (curr.right!=null)
                    q.add(curr.right);
            }

            res.add(currList);
        }

        return res;
    }
}