class Pair {
    int row;
    int col;

    Pair(int row,int col) {
        this.row=row;
        this.col=col;
    }
}

class Solution {
    int[] dRow={-1,0,1,0};
    int[] dCol={0,1,0,-1};

    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visited=new boolean[m][n];
        int numOfIslands=0;

        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (grid[i][j]=='1' && !visited[i][j]) {
                    bfs(i,j,visited,grid,m,n);
                    numOfIslands++;
                }
            }
        }

        return numOfIslands;
    }

    public void bfs(int r,int c,boolean[][] visited,char[][] grid,int m,int n) {
        Queue<Pair> q=new LinkedList<>();
        visited[r][c]=true;
        q.add(new Pair(r,c));

        while (!q.isEmpty()) {
            Pair curr=q.poll();
            int currRow=curr.row;
            int currCol=curr.col;

            for (int i=0;i<4;i++) {
                int newRow=currRow+dRow[i];
                int newCol=currCol+dCol[i];

                if (newRow>=0 && newRow<m && newCol>=0 && newCol<n && grid[newRow][newCol]=='1' && !visited[newRow][newCol]) {
                    q.add(new Pair(newRow,newCol));
                    visited[newRow][newCol]=true;
                }
            }
        }
    }
}

/*
        r-1,c
r,c-1    r,c    r,c+1
        r+1,c
*/