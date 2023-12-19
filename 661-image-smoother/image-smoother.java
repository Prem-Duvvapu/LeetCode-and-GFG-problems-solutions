class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m=img.length;
        int n=img[0].length;
        int[][] res=new int[m][n];

        int[] dx={1,1,1,0,0,0,-1,-1,-1};
        int[] dy={1,-1,0,1,-1,0,1,-1,0};

        for (int i=0;i<m;i++)
        {
            for (int j=0;j<n;j++)
            {
                int sum=0;
                int cnt=0;
                for (int k=0;k<9;k++)
                {
                    int r=i+dx[k];
                    int c=j+dy[k];
                    if (r>=0 && r<m && c>=0 && c<n)
                    {
                        sum+=img[r][c];
                        cnt++;
                    }
                }
                res[i][j]=sum/cnt;
            }
        }

        return res;
    }
}