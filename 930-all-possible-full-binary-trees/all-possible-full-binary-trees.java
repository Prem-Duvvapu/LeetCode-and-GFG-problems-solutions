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
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> res=new ArrayList<>();

        if ((n&1)==0) //even
            return res;

        if (n==1)
        {
            res.add(new TreeNode(0));
            return res;
        }

        for (int i=1;i<n;i+=2)
        {
            List<TreeNode> lft=allPossibleFBT(i);
            List<TreeNode> rght=allPossibleFBT(n-i-1);
            for (int j=0;j<lft.size();j++)
            {
                for (int k=0;k<rght.size();k++)
                {
                    TreeNode curr=new TreeNode(0);
                    curr.left=lft.get(j);
                    curr.right=rght.get(k);
                    res.add(curr);
                }
            }
        }

        return res;
    }
}