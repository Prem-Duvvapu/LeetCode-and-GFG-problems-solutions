class Solution {
    int[] dRow={-1,0,1,0};
    int[] dCol={0,1,0,-1};

    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        boolean[][] visited=new boolean[m][n];

        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if ((i==0 || j==0 || i==m-1 || j==n-1) && (board[i][j]=='O'))
                    dfs(i,j,visited,board,m,n);
            }
        }

        for (int i=1;i<m-1;i++)
            for (int j=1;j<n-1;j++)
                if (board[i][j]=='O' && !visited[i][j])
                    board[i][j]='X';
    }

    public void dfs(int r,int c,boolean[][] visited,char[][] board,int m,int n) {
        visited[r][c]=true;

        for (int i=0;i<4;i++) {
            int newRow=r+dRow[i];
            int newCol=c+dCol[i];

            if (newRow>=0 && newRow<m && newCol>=0 && newCol<n && board[newRow][newCol]=='O' && !visited[newRow][newCol])
                dfs(newRow,newCol,visited,board,m,n);
        }
    }
}

