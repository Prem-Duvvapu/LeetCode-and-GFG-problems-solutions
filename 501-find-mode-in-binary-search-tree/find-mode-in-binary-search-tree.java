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
    public int[] findMode(TreeNode root) {
        Map<Integer,Integer> map=new HashMap<>();
        inorder(root,map);
        int maxCnt=0;

        for (Map.Entry<Integer,Integer> m: map.entrySet())
            if (m.getValue()>maxCnt)
                maxCnt=m.getValue();
        
        List<Integer> l=new ArrayList<>();
        for (Map.Entry<Integer,Integer> m: map.entrySet())
            if (m.getValue()==maxCnt)
                l.add(m.getKey());
        
        int[] res=new int[l.size()];
        for (int i=0;i<l.size();i++)
            res[i]=l.get(i);

        return res;
    }

    private void inorder(TreeNode root,Map<Integer,Integer> map)
    {
        if (root==null)
            return;

        inorder(root.left,map);
        map.put(root.val,map.getOrDefault(root.val,0)+1);
        inorder(root.right,map);
    }
}