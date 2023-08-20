//Tabulation

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int minVal=Integer.MAX_VALUE;
        int[][] dp=new int[n][n];

        for (int i=0;i<n;i++)
            dp[0][i]=matrix[0][i];

        for (int i=1;i<n;i++)
        {
            for (int j=0;j<n;j++)
            {
                int up=dp[i-1][j];
                int left=Integer.MAX_VALUE;
                int right=Integer.MAX_VALUE;

                if (j>0)
                    left=dp[i-1][j-1];

                if (j<n-1)
                    right=dp[i-1][j+1];

                dp[i][j]=matrix[i][j]+Math.min(up,Math.min(left,right));
            }
        }

        for (int i=0;i<n;i++)
            minVal=Math.min(dp[n-1][i],minVal);

        return minVal;
    }
}