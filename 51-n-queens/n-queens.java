class Solution {
    private void solve(int col,int n,char[][] chessBoard,boolean[] rowCheck,boolean[] lowerDiagonalCheck,boolean[] upperDiagonalCheck,List<List<String>> res) {
        if (col==n) {
            List<String> currList=new ArrayList<>();
            for (int i=0;i<n;i++) {
                String boardRow="";
                for (int j=0;j<n;j++) {
                    boardRow+=chessBoard[i][j];
                }
                currList.add(boardRow);
            }
            res.add(new ArrayList<>(currList));
            return;
        }

        for (int row=0;row<n;row++) {
            if (!rowCheck[row] && !lowerDiagonalCheck[row+col] && !upperDiagonalCheck[n-1+row-col]) {
                chessBoard[row][col]='Q';
                rowCheck[row]=true;
                lowerDiagonalCheck[row+col]=true;
                upperDiagonalCheck[n-1+row-col]=true;

                solve(col+1,n,chessBoard,rowCheck,lowerDiagonalCheck,upperDiagonalCheck,res);

                chessBoard[row][col]='.';
                rowCheck[row]=false;
                lowerDiagonalCheck[row+col]=false;
                upperDiagonalCheck[n-1+row-col]=false;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        char[][] chessBoard=new char[n][n];
        boolean[] rowCheck=new boolean[n];
        boolean[] lowerDiagonalCheck=new boolean[2*n-1];
        boolean[] upperDiagonalCheck=new boolean[2*n-1];

        for (int i=0;i<n;i++)
            for (int j=0;j<n;j++)
                chessBoard[i][j]='.';

        solve(0,n,chessBoard,rowCheck,lowerDiagonalCheck,upperDiagonalCheck,res);
        return res;
    }
}