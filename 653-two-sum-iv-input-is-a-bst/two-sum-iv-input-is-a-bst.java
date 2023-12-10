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
class BSTIterator
{
    Stack<TreeNode> stack=new Stack<>();
    boolean isReverse;

    BSTIterator(TreeNode root,boolean _isReverse)
    {
        isReverse=_isReverse;
        pushAll(root);
    }

    public int nextOrBefore()
    {
        TreeNode temp=stack.pop();
        if (isReverse)
            pushAll(temp.left);
        else
            pushAll(temp.right);
        return temp.val;
    }

    public void pushAll(TreeNode root)
    {
        while (root!=null)
        {
            stack.push(root);
            if (isReverse)
                root=root.right;
            else
                root=root.left;
        }
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator l=new BSTIterator(root,false);
        BSTIterator r=new BSTIterator(root,true);

        int i=l.nextOrBefore();
        int j=r.nextOrBefore();

        while (i<j)
        {
            if (i+j<k)
                i=l.nextOrBefore();
            else if (i+j>k)
                j=r.nextOrBefore();
            else //(i+j==k)
                return true;
        }

        return false;
    }
}