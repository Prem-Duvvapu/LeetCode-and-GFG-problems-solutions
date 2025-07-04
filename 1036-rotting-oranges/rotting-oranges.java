class Pair {
    int row;
    int col;

    Pair(int row,int col) {
        this.row=row;
        this.col=col;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int freshCnt=0;
        Queue<Pair> q=new LinkedList<>();
        boolean[][] visited=new boolean[m][n];

        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (grid[i][j]==1) {
                    freshCnt++;
                } else if (grid[i][j]==2) {
                    q.add(new Pair(i,j));
                    visited[i][j]=true;
                }
            }
        }

        if (freshCnt==0)
            return 0;

        int[] dRow={-1,0,1,0};
        int[] dCol={0,1,0,-1};
        int time=0;

        while (!q.isEmpty()) {
            int qlen=q.size();

            while (qlen-- > 0) {
                Pair top=q.poll();
                int currRow=top.row;
                int currCol=top.col;

                for (int i=0;i<4;i++) {
                    int newRow=currRow+dRow[i];
                    int newCol=currCol+dCol[i];

                    if (newRow>=0 && newRow<m && newCol>=0 && newCol<n && !visited[newRow][newCol] && grid[newRow][newCol]==1) {
                        visited[newRow][newCol]=true;
                        q.add(new Pair(newRow, newCol));
                        freshCnt--;
                    }
                }
            }

            if (!q.isEmpty())
                time++;
        }

        if (freshCnt>0)
            return -1;

        return time;
    }
}