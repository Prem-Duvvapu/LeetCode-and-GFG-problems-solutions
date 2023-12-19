//BFS

class Pair {
    int row;
    int col;

    Pair(int _row,int _col) {
        row=_row;
        col=_col;
    }
}

class Solution {
    int[] dx={-1,0,1,0};
    int[] dy={0,1,0,-1};

    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visited=new boolean[m][n];
        int cnt=0;

        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (grid[i][j]=='1' && !visited[i][j]) {
                    cnt++;
                    bfs(i,j,grid,visited,m,n);
                }
            }
        }

        return cnt;
    }

    private void bfs(int r,int c,char[][] grid,boolean[][] visited,int m,int n) {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(r,c));
        visited[r][c]=true;

        while (!q.isEmpty()) {
            Pair curr=q.poll();
            for (int i=0;i<4;i++) {
                int newRow=curr.row+dx[i];
                int newCol=curr.col+dy[i];
                if (newRow>=0 && newRow<m && newCol>=0 && newCol<n && grid[newRow][newCol]=='1' && !visited[newRow][newCol]) {
                    q.add(new Pair(newRow,newCol));
                    visited[newRow][newCol]=true;
                }
            }
        }
    }
}