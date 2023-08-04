class Solution {
    int mod=2000000000;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] unqPaths=new int[m][n];

        //first row
        for (int i=0;i<n;i++)
        {
            if (obstacleGrid[0][i]==1)
                break;
            
            unqPaths[0][i]=1;
        }

        //first column
        for (int i=0;i<m;i++)
        {
            if (obstacleGrid[i][0]==1)
                break;

            unqPaths[i][0]=1;
        }

        for (int i=1;i<m;i++)
            for (int j=1;j<n;j++)
                if (obstacleGrid[i][j]!=1)
                    unqPaths[i][j]=unqPaths[i][j-1]+unqPaths[i-1][j];

        return unqPaths[m-1][n-1];
    }
}