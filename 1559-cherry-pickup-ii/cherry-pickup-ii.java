//Space Optimization(3D -> 2D)

class Solution {
    public int cherryPickup(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] next=new int[n][n];

        for (int j1=0;j1<n;j1++)
        {
            for (int j2=0;j2<n;j2++)
            {
                if (j1==j2)
                    next[j1][j2]=grid[m-1][j1];
                else
                    next[j1][j2]=grid[m-1][j1]+grid[m-1][j2];
            }
        }

        for (int i=m-2;i>=0;i--)
        {
            int[][] curr=new int[n][n];
            for (int j1=0;j1<n;j1++)
            {
                for (int j2=0;j2<n;j2++)
                {
                    int maxi=(int)(-1e8);
                    for (int dj1=-1;dj1<=1;dj1++)
                    {
                        for (int dj2=-1;dj2<=1;dj2++)
                        {
                            int value=0;
                            if (j1==j2)
                                value=grid[i][j1];
                            else
                                value=grid[i][j1]+grid[i][j2];

                            if (j1+dj1>=0 && j1+dj1<n && j2+dj2>=0 && j2+dj2<n)
                                value+=next[j1+dj1][j2+dj2];
                            else
                                value+=(int)(-1e8);
                            maxi=Math.max(maxi,value);
                        }
                    }
                    curr[j1][j2]=maxi;
                }
            }

            for (int x=0;x<n;x++)
                for (int y=0;y<n;y++)
                    next[x][y]=curr[x][y];
        }

        return next[0][n-1];
    }
}