class Solution {
    char[] nums = {'1','2','3','4','5','6','7','8','9'};
    public void solveSudoku(char[][] board) {
        solve(board,0,0);
    }

    private boolean solve(char[][] board,int r,int c) {
        if (c==9) {
            r+=1;
            c=0;
        }

        for (int i=0;i<9;i++) {
            for (int j=0;j<9;j++) {
                if (board[i][j]=='.') {
                    for (int k=0;k<9;k++) {
                        if (isValid(board,i,j,nums[k])) {
                            board[i][j]=nums[k];
                            if (solve(board,r,c+1))
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

    private boolean isValid(char[][] board,int r,int c,char ch) {
        for (int i=0;i<9;i++) {
            //row check
            if (board[i][c]==ch)
                return false;

            //column check
            if (board[r][i]==ch)
                return false;

            //subbox check
            int newRow = 3 * (r/3) + i/3;
            int newCol = 3 * (c/3) + i%3;

            if (board[newRow][newCol]==ch)
                return false;
        }

        return true;
    }
}