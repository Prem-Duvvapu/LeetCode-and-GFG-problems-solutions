class Solution {
    static final int MOD=1_000_000_007;

    public int numTilings(int n) {
        int[][] dp=new int[n][2];
        for (int[] arr: dp)
            Arrays.fill(arr,-1);

        return solve(0,n,0,dp);
    }

    public int solve(int pos,int n,int isTromino,int[][] dp) {
        if (pos>n)
            return 0;

        if (pos==n) {
            return 1-isTromino;
        }

        if (dp[pos][isTromino]!=-1)
            return dp[pos][isTromino];

        int ways=0;

        if (isTromino==1) {
            ways=solve(pos+2,n,0,dp);
            ways=(ways+solve(pos+1,n,1,dp))%MOD;
        } else {
            ways=solve(pos+1,n,0,dp);
            ways=(ways+solve(pos+2,n,0,dp))%MOD;
            ways=(ways+solve(pos+1,n,1,dp))%MOD;
            ways=(ways+solve(pos+1,n,1,dp))%MOD;
        }

        return dp[pos][isTromino]=ways;
    }
}