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
        Queue<TreeNode> q=new ArrayDeque<>();
        q.add(root);
        map.put(root,null);
        while (!q.isEmpty())
        {
            TreeNode curr=q.poll();

            if(curr.left!=null)
            {
                map.put(curr.left,curr);
                q.offer(curr.left);
            }

            if (curr.right!=null)
            {
                map.put(curr.right,curr);
                q.offer(curr.right);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k)
    {
        List<Integer> res=new ArrayList<>();
        Map<TreeNode,TreeNode> map=new HashMap<>();
        childToParent(root,map);
        Set<TreeNode> set=new HashSet<>();
        Queue<TreeNode> q=new ArrayDeque<>();
        q.add(target);
        set.add(target);
        int distance=0;

        while (!q.isEmpty())
        {
            if (distance==k)
                break;

            distance++;
            int qlen=q.size();
            while (qlen-- > 0)
            {
                TreeNode curr=q.poll();
                if (curr.left!=null && !set.contains(curr.left))
                {
                    q.add(curr.left);
                    set.add(curr.left);
                }
                if (curr.right!=null && !set.contains(curr.right))
                {
                    q.add(curr.right);
                    set.add(curr.right);
                }
                if (map.get(curr)!=null && !set.contains(map.get(curr)))
                {
                    q.add(map.get(curr));
                    set.add(map.get(curr));
                }
            }
        }

        while (!q.isEmpty())
            res.add(q.poll().val);

        return res;
    }
}