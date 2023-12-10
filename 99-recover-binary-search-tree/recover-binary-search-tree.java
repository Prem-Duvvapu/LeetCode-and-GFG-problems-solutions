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
    public void recoverTree(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        preorder(root,list);
        Collections.sort(list);
        int[] i=new int[1];
        inorder(root,list,i);
    }

    private void preorder(TreeNode root,List<Integer> list)
    {
        if (root==null)
            return;

        list.add(root.val);
        preorder(root.left,list);
        preorder(root.right,list);
    }

    private void inorder(TreeNode root,List<Integer> list,int[] i)
    {
        if (root==null)
            return;
        inorder(root.left,list,i);
        if (root.val!=list.get(i[0]))
            root.val=list.get(i[0]);
        i[0]++;
        inorder(root.right,list,i);
    }
}