class Solution {
    int mod=2000000000;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] paths=new int[m][n];

        //first row
        for (int i=0;i<n;i++)
        {
            if (obstacleGrid[0][i]==1)
                break;
            
            paths[0][i]=1;
        }

        //first column
        for (int i=0;i<m;i++)
        {
            if (obstacleGrid[i][0]==1)
                break;

            paths[i][0]=1;
        }

        for (int i=1;i<m;i++)
        {
            for (int j=1;j<n;j++)
            {
                if (obstacleGrid[i][j]==1)
                    continue;

                paths[i][j]=paths[i][j-1]+paths[i-1][j];
            }
        }

        return paths[m-1][n-1];
    }
}