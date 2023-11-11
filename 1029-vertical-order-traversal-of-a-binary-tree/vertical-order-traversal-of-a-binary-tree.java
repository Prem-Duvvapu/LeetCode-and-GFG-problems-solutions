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
    int col;
    int row;
    Tuple(TreeNode _node,int _col,int _row)
    {
        node=_node;
        col=_col;
        row=_row;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
        Queue<Tuple> q=new ArrayDeque<>();
        Tuple t=new Tuple(root,0,0);
        q.add(t);

        while (!q.isEmpty())
        {
            Tuple curr=q.poll();
            TreeNode node=curr.node;
            int x=curr.col;
            int y=curr.row;

            if (!map.containsKey(x))
                map.put(x,new TreeMap<>());

            if (!map.get(x).containsKey(y))
                map.get(x).put(y,new PriorityQueue<>());

            map.get(x).get(y).offer(node.val);

            if (node.left!=null)
                q.add(new Tuple(node.left,x-1,y+1));

            if (node.right!=null)
                q.add(new Tuple(node.right,x+1,y+1));
        }

        List<List<Integer>> res=new ArrayList<>();
        for (TreeMap<Integer,PriorityQueue<Integer>> c: map.values())
        {
            res.add(new ArrayList<>());
            for (PriorityQueue<Integer> r: c.values())
                while (!r.isEmpty())
                    res.get(res.size()-1).add(r.poll());
        }

        return res;
    }
}