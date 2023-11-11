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
class Tuple
{
    TreeNode node;
    int row;

    Tuple(TreeNode _node,int _row)
    {
        node=_node;
        row=_row;
    }
}

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if (root==null)
            return res;
        TreeMap<Integer,Integer> map=new TreeMap<>();
        Queue<Tuple> q=new ArrayDeque<>();
        q.offer(new Tuple(root,0));

        while (!q.isEmpty())
        {
            Tuple curr=q.poll();
            map.put(curr.row,curr.node.val);

            if (curr.node.left!=null)
                q.add(new Tuple(curr.node.left,curr.row+1));
            
            if (curr.node.right!=null)
                q.add(new Tuple(curr.node.right,curr.row+1));
        }

        for (Integer val: map.values())
            res.add(val);

        return res;
    }
}