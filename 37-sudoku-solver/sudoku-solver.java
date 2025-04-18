class Solution {
    public void solveSudoku(char[][] board) {
        solve(0,0,board);
    }

    public boolean solve(int r,int c,char[][] board) {
        if (r==8 && c==9)
            return true;

        if (c==9) {
            r+=1;
            c=0;
        }

        if (board[r][c]=='.') {
            for (char ch='1';ch<='9';ch++) {
                if (isSafe(r,c,ch,board)) {
                    board[r][c]=ch;

                    if (solve(r,c+1,board))
                        return true;
                        
                    board[r][c]='.';
                }
            }
            return false;
        }
        
        return solve(r,c+1,board);
    }

    public boolean isSafe(int r,int c,char ch,char[][] board) {
        for (int i=0;i<9;i++) {
            //row check
            if (board[r][i]==ch)
                return false;

            //col check
            if (board[i][c]==ch)
                return false;

            //sub-box
            int newRow = 3 * (r/3) + i/3; 
            int newCol = 3 * (c/3) + i%3;

            if (board[newRow][newCol]==ch)
                return false;
        }

        return true;
    }
}

/*
(0,3) (0,4) (0,5)
(1,3) (1,4) (1,5)
(2,3) (2,4) (2,5)

gridNum=1

i
0 - (0,3)
1 - (0,4)
2 - (0,5)
3 - (1,3)
.
.
.
8 - (2,5)

r, c, i

r -> 0 to 2
c -> 3 to 5

r=1 c=5 

newRow=i/3
newCol=3+i%3

i   r  c
0   0  3
1   0  4
2   0  5

3   1  3
4   1  4
5   1  5

6   2  3
7   2  4
8   2  5

(r/3)*3+c/3

0 1 2
3 



*/