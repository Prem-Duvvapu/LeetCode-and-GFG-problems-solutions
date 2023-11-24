/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null)
            return "";

        StringBuilder res=new StringBuilder();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while (!q.isEmpty())
        {
            TreeNode curr=q.poll();
            if (curr==null)
            {
                res.append("n ");
                continue;
            }

            res.append(curr.val+" ");
            q.add(curr.left);
            q.add(curr.right);
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length()==0)
            return null;

        String[] a=data.split(" ");
        TreeNode root=new TreeNode(Integer.parseInt(a[0]));
        Queue<TreeNode> q=new LinkedList();
        q.add(root);

        for (int i=1;i<a.length;i++)
        {
            TreeNode parent=q.poll();
            if (!a[i].equals("n"))
            {
                TreeNode left=new TreeNode(Integer.parseInt(a[i]));
                parent.left=left;
                q.add(left);
            }
            
            if (!a[++i].equals("n"))
            {
                TreeNode right=new TreeNode(Integer.parseInt(a[i]));
                parent.right=right;
                q.add(right);
            }
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));