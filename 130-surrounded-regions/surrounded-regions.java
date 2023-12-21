class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        boolean[][] visited=new boolean[m][n];

        for (int i=0;i<m;i++)
            for (int j=0;j<n;j++)
                if ((i==0 || i==m-1 || j==0 || j==n-1) && board[i][j]=='O' && !visited[i][j])
                    dfs(i,j,visited,board,m,n);
        
        for (int i=0;i<m;i++)
            for (int j=0;j<n;j++)
                if (board[i][j]=='O' && !visited[i][j])
                    board[i][j]='X';
    }

    private void dfs(int r,int c,boolean[][] visited,char[][] board,int m,int n) {
        visited[r][c]=true;

        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};

        for (int i=0;i<4;i++) {
            int nrow=r+drow[i];
            int ncol=c+dcol[i];

            if (nrow>=0 && nrow<m && ncol>=0 && ncol<n && board[nrow][ncol]=='O' && !visited[nrow][ncol])
                dfs(nrow,ncol,visited,board,m,n);
        }
    }
}