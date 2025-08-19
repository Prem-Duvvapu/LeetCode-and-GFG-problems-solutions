class Pair {
    int row;
    int col;

    Pair(int row,int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public static int[] dRow = {-1,0,1,0};
    public static int[] dCol = {0,1,0,-1};

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int freshCnt = 0;
        boolean[][] visited = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();

        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (grid[i][j] == 1) {
                    freshCnt++;
                } else if (grid[i][j] == 2) {
                    visited[i][j] = true;
                    q.add(new Pair(i,j));
                }
            }
        }

        return bfs(freshCnt,visited,q,grid,m,n);
    }

    private int bfs(int freshCnt,boolean[][] visited,Queue<Pair> q,int[][] grid,int m,int n) {
        int minutes = 0;

        while (!q.isEmpty()) {
            int qlen = q.size();

            while (qlen-- > 0) {
                Pair curr = q.poll();
                int currRow = curr.row;
                int currCol = curr.col;

                for (int i=0;i<4;i++) {
                    int newRow = currRow + dRow[i];
                    int newCol = currCol + dCol[i];

                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol]==1 && !visited[newRow][newCol]) {
                        visited[newRow][newCol] = true;
                        q.add(new Pair(newRow, newCol));
                        freshCnt--;
                    }
                }
            }

            if (!q.isEmpty())
                minutes++;
        }

        return (freshCnt == 0) ? minutes : -1;
    }
}