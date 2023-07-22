class Solution {
    int[] r={1,2,1,2,-1,-2,-1,-2};
    int[] c={2,1,-2,-1,2,1,-2,-1};

    public double knightProbability(int n, int k, int row, int column) {
        Double[][][] dp=new Double[n][n][k+1];
        return prob(n,k,row,column,dp);
    }

    private double prob(int n,int k,int row,int col,Double[][][] dp)
    {
        if (row<0 || row>=n || col<0 || col>=n)
            return 0;

        if (k==0)
            return 1;

        if (dp[row][col][k]!=null)
            return dp[row][col][k];

        double probability=0;

        for (int i=0;i<8;i++)
            probability+=prob(n,k-1,row+r[i],col+c[i],dp)/8.0;

        return dp[row][col][k]=probability;
    }
}