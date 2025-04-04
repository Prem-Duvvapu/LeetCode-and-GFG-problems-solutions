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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root==null)
            return root;

        HashMap<Integer,TreeNode> childToParent=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        int maxDepth=calcMaxDepth(root);

        q.add(root);
        int currDepth=0;
        while (!q.isEmpty()) {
            int qlen=q.size();

            while (qlen-- > 0) {
                TreeNode curr=q.poll();

                if (curr.left!=null) {
                    childToParent.put(curr.left.val,curr);
                    q.add(curr.left);
                }

                if (curr.right!=null) {
                    childToParent.put(curr.right.val,curr);
                    q.add(curr.right);
                }
            }

            if (!q.isEmpty())
                currDepth++;
            
            if (currDepth==maxDepth)
                break;
        }

        Set<TreeNode> set=new HashSet<>();
        while (!q.isEmpty())
            set.add(q.poll());

        while (set.size()>1) {
            Set<TreeNode> temp=new HashSet<>();

            for (TreeNode child: set)
                temp.add(childToParent.get(child.val));
            
            set=new HashSet<>(temp);
        }

        for (TreeNode res: set)
            return res;

        return root;
    }

    public int calcMaxDepth(TreeNode root) {
        if (root==null)
            return -1;

        int leftDepth=calcMaxDepth(root.left);
        int rightDepth=calcMaxDepth(root.right);

        return 1+Math.max(leftDepth,rightDepth);
    }
}