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
    private  List<TreeNode> solve(int start,int end,List<TreeNode>[][] dp)
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

        if (dp[start][end]!=null)
            return dp[start][end];

        for (int i=start;i<=end;i++)
        {
            List<TreeNode> leftSubTrees=solve(start,i-1,dp);
            List<TreeNode> rightSubTrees=solve(i+1,end,dp);
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

        return dp[start][end]=res;
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[][] dp=new ArrayList[n+1][n+1];
        return solve(1,n,dp);
    }
}

/*
no. of BSTs can be formed for given value of 'n'=(4 power n)/(n power 1.5)
T.C. :-  n*((4 power n)/(n power 1.5))
*/