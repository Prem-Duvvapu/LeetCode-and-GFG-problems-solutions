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
        stack.push(root);

        while (!stack.isEmpty())
        {
            TreeNode curr=stack.pop();
            if (curr.left!=null)
                stack.push(curr.left);
            if (curr.right!=null)
                stack.push(curr.right);
            res.add(0,curr.val);
        }

        // Collections.reverse(res);

        return res;
    }
}