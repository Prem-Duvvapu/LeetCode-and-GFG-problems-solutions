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
    private  List<TreeNode> solve(int start,int end)
    {
        List<TreeNode> res=new ArrayList<>();
        if (start>end)
        {
            res.add(null);
            return res;
        }

        if (start==end)
        {
            TreeNode t=new TreeNode(start);
            res.add(t);
            return res;
        }

        for (int i=start;i<=end;i++)
        {
            List<TreeNode> leftSubTrees=solve(start,i-1);
            List<TreeNode> rightSubTrees=solve(i+1,end);
            for (TreeNode leftBST: leftSubTrees)
            {
                for (TreeNode rightBST: rightSubTrees)
                {
                    TreeNode root=new TreeNode(i);
                    root.left=leftBST;
                    root.right=rightBST;
                    res.add(root);
                }
            }
        }

        return res;
    }

    public List<TreeNode> generateTrees(int n) {
        return solve(1,n);
    }
}

/*
no. of BSTs can be formed for given value of 'n'=(4 power n)/(n power 1.5)
T.C. :-  n*((4 power n)/(n power 1.5))
*/