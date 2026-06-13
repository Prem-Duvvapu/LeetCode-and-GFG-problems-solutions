class Solution {
    public void solveSudoku(char[][] board) {
        solve(0,0,board);
    }

    private boolean solve(int r,int c,char[][] board) {
        if (c == board[0].length) {
            c = 0;
            r++;
        }

        if (r >= board.length) {
            return true;
        }

        if (board[r][c] != '.') {
            return solve(r,c+1,board);
        }

        for (char ch ='1';ch<='9';ch++) {
            if (isValid(ch,r,c,board)) {
                board[r][c] = ch;
                if (solve(r,c+1,board)) {
                    return true;
                }
                board[r][c] = '.';
            }
        }

        return false;
    }

    private boolean isValid(char ch,int r,int c,char[][] board) {
        for (int i=0;i<board.length;i++) {
            // colCheck
            if (board[i][c] == ch) {
                return false;
            }

            // rowCheck
            if (board[r][i] == ch) {
                return false;
            }

            // gridCheck
            int newRow = 3 * (r/3) + i/3;
            int newCol = 3 * (c/3) + i%3;
            if (board[newRow][newCol] == ch) {
                return false;
            }
        }

        return true;
    }
}