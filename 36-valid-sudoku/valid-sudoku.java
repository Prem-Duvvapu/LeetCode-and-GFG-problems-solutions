class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowCheck=new boolean[10][10];
        boolean[][] colCheck=new boolean[10][10];
        boolean[][] subBoxCheck=new boolean[10][10];

        for (int i=0;i<9;i++)
        {
            for (int j=0;j<9;j++)
            {
                char ch=board[i][j];
                if (ch=='.')
                    continue;

                int val=(ch-'0');

                if (rowCheck[i+1][val]) //row number (1 to 9)
                    return false;
                rowCheck[i+1][val]=true;

                if (colCheck[j+1][val]) //col number (1 to 9)
                    return false;
                colCheck[j+1][val]=true;

                int n=i/3*3+j/3+1;    //subBox number (1 to 9)
                if (subBoxCheck[n][val])
                    return false;
                subBoxCheck[n][val]=true;
            }
        }

        return true;
    }
}