class Solution {
    public static int[] dRow = {-1, 0, 1, 0};
    public static int[] dCol = {0, 1, 0, -1};

    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int cnt = 0;
        boolean[][] visited = new boolean[m][n];

        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if ((i == 0 || i == m-1 || j == 0 || j == n-1) && grid[i][j] == 1 && !visited[i][j])
                    dfs(i, j, visited, grid, m, n);
            }
        }

        for (int i=1;i<m-1;i++) {
            for (int j=1;j<n-1;j++) {
                if (grid[i][j] == 1 && !visited[i][j])
                    cnt++;
            }
        }

        return cnt;
    }

    private void dfs(int r,int c,boolean[][] visited,int[][] grid,int m,int n) {
        visited[r][c] = true;

        for (int i=0;i<4;i++) {
            int newRow = r + dRow[i];
            int newCol = c + dCol[i];

            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1 && !visited[newRow][newCol]) 
                dfs(newRow, newCol, visited, grid, m, n);
        }
    }
}