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
    int n;
    Tuple(TreeNode _node,int _n)
    {
        node=_node;
        n=_n;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int res=1;
        LinkedList<Tuple> ll=new LinkedList<>();
        ll.add(new Tuple(root,1));

        while (ll.size()>0)
        {
            int len=ll.size();
            while (len-- > 0)
            {
                Tuple t=ll.pollFirst();
                TreeNode curr=t.node;
                int num=t.n;
                if (curr.left!=null)
                    ll.add(new Tuple(curr.left,2*num));
                if (curr.right!=null)
                    ll.add(new Tuple(curr.right,2*num+1));
            }
            if (ll.size()>0)
                res=Math.max(res,ll.getLast().n-ll.getFirst().n+1);
        }

        return res;
    }
}