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
    public TreeNode temp;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";

        StringBuilder res = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        while (!q.isEmpty())  {
            TreeNode curr = q.poll();

            if (curr != null) {
                res.append(curr.val+" ");
                q.add(curr.left);
                q.add(curr.right);
            } else {
                res.append("n ");
            }
        }

        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0)
            return null;

        String[] arr = data.split(" ");
        System.out.println(Arrays.toString(arr));
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        for (int i=1;i<arr.length-1;i+=2) {
            TreeNode parent = q.poll();

            if (!arr[i].equals("n")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(arr[i]));
                parent.left = leftNode;
                q.add(leftNode);
            }

            if (!arr[i+1].equals("n")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(arr[i+1]));
                parent.right = rightNode;
                q.add(rightNode);
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));