class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int minVal=Integer.MAX_VALUE;
        int[][] dp=new int[n][n];
        System.out.println(n);

        for (int i=0;i<n;i++)
            for (int j=0;j<n;j++)
                dp[i][j]=-1000000;
                
        for (int j=0;j<n;j++)
            minVal=Math.min(minVal,solve(0,j,matrix,n,dp));

        return minVal;
    }

    private int solve(int i,int j,int[][] matrix,int n,int[][] dp) {
        if (i==n)
            return 0;

        if (j==n)
            return 1000000;

        if (dp[i][j]!=-1000000)
            return dp[i][j];

        int left=1000000;
        int right=1000000;

        //left
        if (j-1>=0)
            left=solve(i+1,j-1,matrix,n,dp);

        //down
        int down=solve(i+1,j,matrix,n,dp);

        //right
        if (j+1<n)
            right=solve(i+1,j+1,matrix,n,dp);

        return dp[i][j]=matrix[i][j]+Math.min(down,Math.min(left,right));
    }
}