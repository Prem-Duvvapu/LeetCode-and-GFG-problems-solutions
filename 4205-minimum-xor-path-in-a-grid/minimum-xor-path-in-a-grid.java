class Tuple {
    int row;
    int col;
    int val;

    public Tuple(int row,int col,int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}

class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][][] visited = new boolean[m][n][1024];

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0,0,grid[0][0]));
        visited[0][0][grid[0][0]] = true;

        while (!q.isEmpty()) {
            Tuple curr = q.poll();
            int currRow = curr.row;
            int currCol = curr.col;
            int currVal = curr.val;

            // down
            if (currRow+1 < m) {
                int newVal = currVal ^ grid[currRow+1][currCol];
                if (!visited[currRow+1][currCol][newVal]) {
                    visited[currRow+1][currCol][newVal] = true;
                    q.add(new Tuple(currRow+1,currCol,newVal));
                }
            }

            // right
            if (currCol+1 < n) {
                int newVal = currVal ^ grid[currRow][currCol+1];
                if (!visited[currRow][currCol+1][newVal]) {
                    visited[currRow][currCol+1][newVal] = true;
                    q.add(new Tuple(currRow,currCol+1,newVal));
                }
            }
        }

        for (int i=0;i<1024;i++) {
            if (visited[m-1][n-1][i]) {
                return i;
            }
        }

        return -1;
    }
}