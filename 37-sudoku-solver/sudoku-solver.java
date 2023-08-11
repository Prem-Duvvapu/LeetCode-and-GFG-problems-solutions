class Solution {
    private boolean isValid(char[][] board,int row,int col,char ch)
    {
        for (int i=0;i<9;i++)
        {
            //row check
            if (board[row][i]==ch)
                return false;

            //col check
            if (board[i][col]==ch)
                return false;

            int r=(row/3)*3+i/3;
            int c=(col/3)*3+i%3;
            if (board[r][c]==ch)
                return false;
        }
        return true;
    }

    private boolean solve(char[][] board)
    {
        for (int i=0;i<9;i++)
        {
            for (int j=0;j<9;j++)
            {
                if (board[i][j]=='.')
                {
                    char[] nums={'1','2','3','4','5','6','7','8','9'};
                    for (int k=0;k<9;k++)
                    {
                        if (isValid(board,i,j,nums[k]))
                        {
                            board[i][j]=nums[k];
                            if (solve(board))
                                return true;
                            board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        solve(board);
    }
}