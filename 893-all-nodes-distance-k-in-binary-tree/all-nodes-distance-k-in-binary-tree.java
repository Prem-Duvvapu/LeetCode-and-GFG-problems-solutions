/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Set<TreeNode> set = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();

        nodeToParent(parentMap,root);
        
        q.add(target);
        set.add(target);

        while (k-- > 0) {
            int qlen = q.size();

            while (qlen-- > 0) {
                TreeNode curr = q.poll();

                if (curr.left!=null && !set.contains(curr.left)) {
                    q.add(curr.left);
                    set.add(curr.left);
                }

                if (curr.right!=null && !set.contains(curr.right)) {
                    q.add(curr.right);
                    set.add(curr.right);
                }

                if (parentMap.get(curr)!=null && !set.contains(parentMap.get(curr))) {
                    q.add(parentMap.get(curr));
                    set.add(parentMap.get(curr));
                }
            }
        }
        
        while (!q.isEmpty())
            res.add(q.poll().val);

        return res;
    }

    private void nodeToParent(Map<TreeNode, TreeNode> map, TreeNode root) {
        if (root == null)
            return;

        if (root.left!=null)
            map.put(root.left,root);

        if (root.right!=null)
            map.put(root.right,root);

        nodeToParent(map,root.left);
        nodeToParent(map,root.right);
    }
}