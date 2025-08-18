class Solution {
    public static int[] dRow = {-1,0,1,0};
    public static int[] dCol = {0,1,0,-1};

    public int numIslands(char[][] grid) {
        int cnt = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    cnt++;
                    dfs(i,j,visited,grid,m,n);
                }
            }
        }

        return cnt;
    }

    private void dfs(int r,int c,boolean[][] visited,char[][] grid,int m,int n) {
        visited[r][c] = true;

        for (int i=0;i<4;i++) {
            int newRow = r + dRow[i];
            int newCol = c + dCol[i];

            if (newRow >=0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == '1' && !visited[newRow][newCol])
                dfs(newRow,newCol,visited,grid,m,n);
        }
    }
}