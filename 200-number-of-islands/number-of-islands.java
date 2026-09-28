class Solution {
    private static final int[] dRow = {-1,0,1,0};
    private static final int[] dCol = {0,1,0,-1};

    public int numIslands(char[][] grid) {
       int n = grid.length;
       int m = grid[0].length;
       boolean[][] visited = new boolean[n][m];
       int numIslands = 0;

       for (int i=0;i<n;i++) {
        for (int j=0;j<m;j++) {
            if (grid[i][j] == '1' && !visited[i][j]) {
                numIslands++;
                dfs(i,j,visited,grid);
            }
        }
       }

       return numIslands;
    }

    private void dfs(int r,int c,boolean[][] visited,char[][] grid) {
        visited[r][c] = true;

        for (int i=0;i<4;i++) {
            int newRow = r + dRow[i];
            int newCol = c + dCol[i];

            if (newRow>=0 && newRow<grid.length && newCol>=0 && newCol<grid[0].length && grid[newRow][newCol]=='1' && !visited[newRow][newCol]) {
                dfs(newRow,newCol,visited,grid);
            }
        }
    }
}

