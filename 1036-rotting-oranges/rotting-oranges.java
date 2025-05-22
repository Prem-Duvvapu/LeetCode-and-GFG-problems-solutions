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

    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visited=new boolean[m][n];
        Queue<Pair> q=new LinkedList<>();
        int freshCnt=0;
        int time=0;

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

        while (!q.isEmpty()) {
            int qlen=q.size();

            while (qlen-- > 0) {
                Pair curr=q.poll();
                int currRow=curr.row;
                int currCol=curr.col;

                for (int i=0;i<4;i++) {
                    int newRow=currRow+dRow[i];
                    int newCol=currCol+dCol[i];

                    if (newRow>=0 & newRow<m && newCol>=0 && newCol<n && grid[newRow][newCol]==1 && !visited[newRow][newCol]) {
                        freshCnt--;
                        q.add(new Pair(newRow,newCol));
                        visited[newRow][newCol]=true;
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

/*

2 1 1
0 1 1
1 0 1

freshCnt
 6         4        2       1         0
2 1 1    2 2 1    2 2 2    2 2 2    2 2 2
1 1 0 -> 2 1 0 -> 2 2 0 -> 2 2 0 -> 2 2 0
0 1 1    0 1 1    0 1 1    0 2 1    0 2 2

time=0     1        2       3        4
ans=4
*/
