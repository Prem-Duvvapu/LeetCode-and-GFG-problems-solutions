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
class FindElements {
    TreeNode root;
    Set<Integer> set=new HashSet<>();

    public FindElements(TreeNode root) {
        if (root==null)
            return;

        this.root=root;
        root.val=0;
        set.add(0);
        solve(root);
    }

    private void solve(TreeNode root) {
        if (root==null)
            return;

        int leftVal=root.val*2+1;
        int rightVal=root.val*2+2;
        
        if (root.left!=null) {
            set.add(leftVal);
            root.left.val=leftVal;
        }

        if (root.right!=null) {
            root.right.val=rightVal;
            set.add(rightVal);
        }

        solve(root.left);
        solve(root.right);
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */