class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowCheck=new boolean[9][9];
        boolean[][] colCheck=new boolean[9][9];
        boolean[][] subBoxCheck=new boolean[9][9];

        for (int i=0;i<9;i++)
        {
            for (int j=0;j<9;j++)
            {
                char ch=board[i][j];
                if (ch=='.')
                    continue;

                int val=(ch-'0')-1;

                if (rowCheck[i][val])
                    return false;
                rowCheck[i][val]=true;

                if (colCheck[j][val])
                    return false;
                colCheck[j][val]=true;

                int n=i/3*3+j/3;    //subBox number
                if (subBoxCheck[n][val])
                    return false;
                subBoxCheck[n][val]=true;
            }
        }

        return true;
    }
}