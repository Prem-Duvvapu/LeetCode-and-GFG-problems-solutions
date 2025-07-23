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
class Pair {
    int index;
    TreeNode node;

    Pair(int index,TreeNode node) {
        this.index = index;
        this.node = node;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        int maxWidth = 0;
        Deque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0,root));

        while (!q.isEmpty()) {
            Pair firstPair = q.peekFirst();
            Pair lastPair = q.peekLast();

            int currWidth = lastPair.index - firstPair.index + 1;
            maxWidth = Math.max(currWidth, maxWidth);

            int qlen = q.size();
            while (qlen-- > 0) {
                Pair currPair = q.poll();
                int currIndex = currPair.index;
                TreeNode currNode = currPair.node;

                if (currNode.left!=null)
                    q.add(new Pair(2*currIndex+1,currNode.left));

                if (currNode.right!=null)
                    q.add(new Pair(2*currIndex+2,currNode.right));
            }
        }

        return maxWidth;
    }
}