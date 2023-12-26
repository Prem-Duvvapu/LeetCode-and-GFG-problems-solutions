//Tabulation
class Solution {
    int mod=(int)1e9+7;
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp=new int[n+1][target+1];
        dp[0][0]=1;

        for (int pos=1;pos<=n;pos++) {
            for (int i=1;i<=target;i++) {
                int cnt=0;
                for (int j=1;j<=k;j++) {
                    if (i-j>=0)
                        cnt=(cnt+dp[pos-1][i-j])%mod;
                }
                dp[pos][i]=cnt;
            }
        }
        

        return dp[n][target];
    }
}