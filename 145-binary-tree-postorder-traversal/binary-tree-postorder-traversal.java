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

 //Iterative using 2 stacks
 //Left Right Root
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();

        if (root==null)
            return res;
        
        Stack<TreeNode> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();
        s1.push(root);

        while (!s1.isEmpty())
        {
            TreeNode curr=s1.pop();
            if (curr.left!=null)
                s1.push(curr.left);
            if (curr.right!=null)
                s1.push(curr.right);
            s2.push(curr.val);
        }

        while (!s2.isEmpty())
            res.add(s2.pop());

        return res;
    }
}