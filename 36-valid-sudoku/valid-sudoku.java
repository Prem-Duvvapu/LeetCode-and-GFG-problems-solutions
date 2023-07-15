class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowCheck=new boolean[10][10]; //row number (1 to 9)
        boolean[][] colCheck=new boolean[10][10]; //col number (1 to 9)
        boolean[][] subBoxCheck=new boolean[10][10]; //subBox number (1 to 9)

        for (int i=0;i<9;i++)
        {
            for (int j=0;j<9;j++)
            {
                char ch=board[i][j];
                if (ch=='.')    //we need only integer characters
                    continue;

                int val=(ch-'0'); //char to integer

                if (rowCheck[i+1][val]) //checking if value already exists in the row
                    return false;
                rowCheck[i+1][val]=true; //now note that the value exists in the row

                if (colCheck[j+1][val]) //checking if value already exists in the column
                    return false;
                colCheck[j+1][val]=true; //now note that the value exists in the column

                int n=i/3+j/3*3+1;    
                if (subBoxCheck[n][val]) //checking if value already exists in the subBox
                    return false;
                subBoxCheck[n][val]=true; //now note that the value exists in the subBox
            }
        }

        return true;
    }
}