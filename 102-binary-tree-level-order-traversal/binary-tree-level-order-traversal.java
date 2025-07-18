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
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            List<Integer> currLevelList = new ArrayList<>();
            int qlen = q.size();

            while (qlen-- > 0) {
                TreeNode curr = q.poll();
                currLevelList.add(curr.val);

                if (curr.left!=null)
                    q.add(curr.left);

                if (curr.right!=null)
                    q.add(curr.right);
            }

            res.add(currLevelList);
        }

        return res;
    }
}