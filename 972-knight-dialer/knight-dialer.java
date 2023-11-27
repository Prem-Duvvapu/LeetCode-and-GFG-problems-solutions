//Recursion
class Solution {
    int mod=(int)1e9+7;
    Integer[][][] dp=new Integer[4][3][5001];

    public int knightDialer(int n) {
        int ans=0;
        for (int i=0;i<4;i++)
        {
            for (int j=0;j<3;j++)
            {
                ans=(ans+solve(i,j,n-1))%mod;
            }
        }
        return ans;
    }

    private int solve(int i,int j,int n)
    {
        if (i==3 && (j==0 || j==2))
            return 0;

        if (n==0)
            return 1;

        if (dp[i][j][n]!=null)
            return dp[i][j][n];

        int curr=0;
        if (i-2>=0 && j+1<3)
            curr=(curr+solve(i-2,j+1,n-1))%mod;

        if (i-1>=0 && j+2<3)
            curr=(curr+solve(i-1,j+2,n-1))%mod;

        if (i+1<4 && j+2<3)
            curr=(curr+solve(i+1,j+2,n-1))%mod;

        if (i+2<4 && j+1<3)
            curr=(curr+solve(i+2,j+1,n-1))%mod;

        if (i+2<4 && j-1>=0)
            curr=(curr+solve(i+2,j-1,n-1))%mod;

        if (i+1<4 && j-2>=0)
            curr=(curr+solve(i+1,j-2,n-1))%mod;

        if (i-1>=0 && j-2>=0)
            curr=(curr+solve(i-1,j-2,n-1))%mod;

        if (i-2>=0 && j-1>=0)
            curr=(curr+solve(i-2,j-1,n-1))%mod;

        return dp[i][j][n]=curr%mod;
    }
}