class Pair {
    int row,col;

    Pair(int _row,int _col) {
        row=_row;
        col=_col;
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
                res[i][j]=-1;
                if (mat[i][j]==0)
                    q.add(new Pair(i,j));
            }
        }

        int cnt=0;
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};

        while (!q.isEmpty()) {
            int qlen=q.size();
            while (qlen-- > 0) {
                Pair curr=q.poll();
                res[curr.row][curr.col]=cnt;
                for (int i=0;i<4;i++) {
                    int nrow=curr.row+drow[i];
                    int ncol=curr.col+dcol[i];
                    if (nrow>=0 && nrow<m && ncol>=0 && ncol<n && mat[nrow][ncol]==1 && res[nrow][ncol]==-1) {
                        res[nrow][ncol]=0;
                        q.add(new Pair(nrow,ncol));
                    }
                }
            }
            cnt++;
        }

        return res;
    }
}