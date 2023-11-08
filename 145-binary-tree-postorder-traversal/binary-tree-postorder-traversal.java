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

 //Iterative using 1 stack
 //Left Right Root
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();

        if (root==null)
            return res;
        
        Stack<TreeNode> stack=new Stack<>();
        TreeNode curr=root;

        while (curr!=null || !stack.isEmpty())
        {
            if (curr!=null)
            {
                stack.add(curr);
                curr=curr.left;
            }
            else
            {
                TreeNode temp=stack.peek().right;
                if (temp==null)
                {
                    temp=stack.pop();
                    res.add(temp.val);
                    while (!stack.isEmpty() && stack.peek().right==temp)
                    {
                        temp=stack.pop();
                        res.add(temp.val);
                    }
                }
                else
                    curr=temp;
            }
        }

        return res;
    }
}