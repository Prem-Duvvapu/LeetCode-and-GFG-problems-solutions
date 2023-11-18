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
    TreeNode target;
    private void childToParent(TreeNode root,Map<TreeNode,TreeNode> map)
    {
        Queue<TreeNode> q=new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty())
        {
            TreeNode curr=q.poll();
            if (curr.left!=null)
            {
                map.put(curr.left,curr);
                q.add(curr.left);
            }
            if (curr.right!=null)
            {
                map.put(curr.right,curr);
                q.add(curr.right);
            }
        }
    }

    private void inorder(TreeNode root,int start)
    {
        if (root==null)
            return;

        if (root.val==start)
            target=root;
        inorder(root.left,start);
        inorder(root.right,start);
    }

    public int amountOfTime(TreeNode root, int start) {
        int time=-1;
        Map<TreeNode,TreeNode> map=new HashMap<>();
        childToParent(root,map);
        target=root;
        inorder(root,start);
        Set<TreeNode> set=new HashSet<>();
        Queue<TreeNode> q=new ArrayDeque<>();
        q.add(target);
        set.add(target);
        if (root.left==null && root.right==null)
            return 0;

        while (!q.isEmpty())
        {
            int qlen=q.size();
            time++;
            while (qlen-- > 0)
            {
                TreeNode curr=q.poll();
                if (curr.left!=null && !set.contains(curr.left))
                {
                    q.add(curr.left);
                    set.add(curr.left);
                }
                if (curr.right!=null && !set.contains(curr.right))
                {
                    q.add(curr.right);
                    set.add(curr.right);
                }
                if (map.get(curr)!=null && !set.contains(map.get(curr)))
                {
                    q.add(map.get(curr));
                    set.add(map.get(curr));
                }
            }
        }

        return time;
    }
}