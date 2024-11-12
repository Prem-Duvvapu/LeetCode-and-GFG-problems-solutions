class Node {
    int minEffort;
    int row;
    int col;

    Node(int _minEffort, int _row, int _col) {
        minEffort = _minEffort;
        row = _row;
        col = _col;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int columns = heights[0].length;
        int[][] minEffortToNode = new int[rows][columns];
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.minEffort, b.minEffort));

        for (int i=0; i<rows; i++)
            Arrays.fill(minEffortToNode[i], (int)1e7);

        minEffortToNode[0][0] = 0;
        pq.add(new Node(0,0,0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            int currRow = curr.row;
            int currCol = curr.col;

            int[] deltaRow = {-1, 0, 1, 0};
            int[] deltaCol = {0, 1, 0, -1};

            for (int i=0; i<4; i++) {
                int newRow = currRow + deltaRow[i];
                int newCol = currCol + deltaCol[i];

                if (newRow>=0 && newRow<rows && newCol>=0 && newCol<columns) {
                    int currDiff = Math.abs(heights[currRow][currCol] - heights[newRow][newCol]);
                    if (minEffortToNode[newRow][newCol] > Math.max(currDiff, minEffortToNode[currRow][currCol])) {
                        minEffortToNode[newRow][newCol] = Math.max(currDiff, minEffortToNode[currRow][currCol]);
                        pq.add(new Node(currDiff, newRow, newCol));
                        System.out.println(minEffortToNode[newRow][newCol]+ " "+newRow + " "+ newCol);

                    }
                }
            }
        }

        return minEffortToNode[rows-1][columns-1];
    }
}