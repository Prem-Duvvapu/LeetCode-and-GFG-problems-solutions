class Pair {
    int row,col;
    Pair(int _row,int _col) {
        row = _row;
        col = _col;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int freshCnt = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int minutes = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    freshCnt++;
                else if (grid[i][j] == 2) {
                    q.add(new Pair(i,j));
                    visited[i][j] = true;
                }
            }
        }

        if (freshCnt == 0)
            return 0;

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        //bfs
        while (!q.isEmpty()) {
            int qlen = q.size();
            minutes++;

            while (qlen-- > 0) {
                Pair curr = q.poll();

                for (int i = 0; i < 4; i++) {
                    int nrow = curr.row + drow[i];
                    int ncol = curr.col + dcol[i];

                    if (nrow>=0 && nrow<m && ncol>=0 && ncol<n && grid[nrow][ncol]==1 && !visited[nrow][ncol]) {
                        freshCnt--;
                        visited[nrow][ncol] = true;
                        q.add(new Pair(nrow, ncol));
                    }
                }
            }
        }

        return (freshCnt > 0) ? -1 : --minutes;
    }
}