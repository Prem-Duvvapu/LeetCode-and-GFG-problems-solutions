//Memoization

class Solution {
    int mod=2000000000;

    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];//step-1
        for (int[] arr: dp)
            Arrays.fill(arr,-1);
        return solve(m-1,n-1,dp);
    }

    private int solve(int m,int n,int[][] dp)
    {
        if (m==0 && n==0)
            return 1;

        if (m<0 || n<0)
            return 0;

        if (dp[m][n]!=-1)//step-3
            return dp[m][n];

        int up=solve(m-1,n,dp);
        int left=solve(m,n-1,dp);

        return dp[m][n]=(up+left)%mod;//step-2
    }
}