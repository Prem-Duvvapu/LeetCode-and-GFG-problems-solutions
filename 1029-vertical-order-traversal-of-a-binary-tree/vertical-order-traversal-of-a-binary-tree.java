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
class Tuple {
    int row;
    int col;
    TreeNode node;

    Tuple(int row,int col,TreeNode node) {
        this.row = row;
        this.col = col;
        this.node = node;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0,0,root));

        while (!q.isEmpty()) {
            Tuple curr = q.poll();
            int currRow = curr.row;
            int currCol = curr.col;
            TreeNode currNode = curr.node;

            map.putIfAbsent(currCol,new TreeMap<>());
            map.get(currCol).putIfAbsent(currRow,new PriorityQueue<>());
            map.get(currCol).get(currRow).add(currNode.val);

            if (currNode.left!=null)
                q.add(new Tuple(currRow+1,currCol-1,currNode.left));

            if (currNode.right!=null)
                q.add(new Tuple(currRow+1,currCol+1,currNode.right));
        }

        for (TreeMap<Integer,PriorityQueue<Integer>> colData: map.values()) {
            List<Integer> list = new ArrayList<>();

            for (PriorityQueue<Integer> pq: colData.values())
                while (!pq.isEmpty())
                    list.add(pq.poll());

            res.add(list);
        }

        return res;
    }
}