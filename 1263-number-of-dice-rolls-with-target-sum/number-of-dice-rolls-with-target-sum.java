class Solution {
    int mod=(int)1e9+7;
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp=new int[n+1][target+1];
        for (int i=0;i<=n;i++)
            for (int j=0;j<=target;j++)
                dp[i][j]=-1;
        return solve(n,k,target,dp);
    }

    private int solve(int n,int k,int target,int[][] dp) {
        if (n==0) {
            if (target==0)
                return 1;
            return 0;
        }

        if (target<0)
            return 0;

        if (dp[n][target]!=-1)
            return dp[n][target];

        int cnt=0;
        for (int i=1;i<=k;i++)
            cnt=(cnt+solve(n-1,k,target-i,dp))%mod;

        return dp[n][target]=cnt;
    }
}