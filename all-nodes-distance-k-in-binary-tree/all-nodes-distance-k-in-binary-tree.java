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
    private void childToParent(TreeNode root,Map<TreeNode,TreeNode> map)
    {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        map.put(root,null);
        while (!q.isEmpty())
        {
            TreeNode curr=q.poll();
            if (curr.left!=null)
            {
                map.put(curr.left,curr);
                q.add(curr.left);
            }
            if (curr.right!=null)
            {
                map.put(curr.right,curr);
                q.add(curr.right);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> map=new HashMap<>();
        childToParent(root,map);
        Set<TreeNode> visited=new HashSet<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(target);
        visited.add(target);
        int currLevel=0;

        while (!q.isEmpty())
        {
            if (currLevel==k)
                break;

            currLevel++;
            int qSize=q.size();
            while (qSize-- > 0)
            {
                TreeNode curr=q.poll();
                if (curr.left!=null && !visited.contains(curr.left))
                {
                    q.add(curr.left);
                    visited.add(curr.left);
                }
                if (curr.right!=null && !visited.contains(curr.right))
                {
                    q.add(curr.right);
                    visited.add(curr.right);
                }
                if (map.get(curr)!=null && !visited.contains(map.get(curr)))
                {
                    q.add(map.get(curr));
                    visited.add(map.get(curr));
                }
            }
        }

        List<Integer> res=new ArrayList<>();
        while (!q.isEmpty())
        {
            TreeNode curr=q.poll();
            res.add(curr.val);
        }

        return res;
    }
}