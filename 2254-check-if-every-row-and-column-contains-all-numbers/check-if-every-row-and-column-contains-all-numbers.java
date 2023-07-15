class Solution {
    public boolean checkValid(int[][] matrix) {
        int n=matrix.length;
        boolean[][] rowCheck=new boolean[n][n];
        boolean[][] colCheck=new boolean[n][n];

        for (int i=0;i<n;i++)
        {
            for (int j=0;j<n;j++)
            {
                int val=matrix[i][j]-1;

                if (rowCheck[i][val])
                    return false;
                rowCheck[i][val]=true;

                if (colCheck[j][val])
                    return false;
                colCheck[j][val]=true;
            }
        }

        return true;
    }
}