class Pair {
    int row;
    int col;

    Pair(int row,int col) {
        this.row=row;
        this.col=col;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] res=new int[m][n];
        Queue<Pair> q=new LinkedList<>();

        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (mat[i][j]==0) {
                    q.add(new Pair(i,j));
                } else {
                    res[i][j]=-1;
                }
            }
        }

        bfs(res,mat,q,m,n);
        
        return res;
    }

    public void bfs(int[][] res,int[][] mat,Queue<Pair> q,int m,int n) {
        int steps=1;
        int[] dRow={-1,0,1,0};
        int[] dCol={0,1,0,-1};

        while (!q.isEmpty()) {
            int qlen=q.size();

            while (qlen-- > 0) {
                Pair curr=q.poll();
                int currRow=curr.row;
                int currCol=curr.col;

                for (int i=0;i<4;i++) {
                    int newRow=currRow+dRow[i];
                    int newCol=currCol+dCol[i];

                    if (newRow>=0 && newRow<m && newCol>=0 && newCol<n && mat[newRow][newCol]==1 && res[newRow][newCol]==-1) {
                        res[newRow][newCol]=steps;
                        q.add(new Pair(newRow,newCol));
                    }
                }
            }

            steps++;
        }
    }
}

/*

0  0  0
0  1  0
1  2  1


steps=3

*/
