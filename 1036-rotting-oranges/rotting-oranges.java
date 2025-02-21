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
        boolean[][] visited=new boolean[m][n];
        int freshCnt=0;
        int time=0;
        Queue<Pair> q=new LinkedList<>();

        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (grid[i][j]==1) {
                    freshCnt++;
                } else if (grid[i][j]==2) {
                    visited[i][j]=true;
                    q.add(new Pair(i,j));
                }
            }
        }

        if (freshCnt==0)
            return time;

        int[] dRow={-1,0,1,0};
        int[] dCol={0,1,0,-1};
        
        while (!q.isEmpty()) {
            int qlen=q.size();
            boolean flag=false;

            while (qlen-- > 0) {
                Pair curr=q.poll();
                int currRow=curr.row;
                int currCol=curr.col;

                for (int i=0;i<4;i++) {
                    int newRow=currRow+dRow[i];
                    int newCol=currCol+dCol[i];

                    if (newRow>=0 && newRow<m && newCol>=0 && newCol<n && grid[newRow][newCol]==1 && !visited[newRow][newCol]) {
                        visited[newRow][newCol]=true;
                        freshCnt--;
                        q.add(new Pair(newRow,newCol));
                        flag=true;
                    }
                }
            }

            if (flag)
                time++;
        }

        if (freshCnt==0)
            return time;

        return -1;
    }
}