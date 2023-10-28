//Tabulation
class Solution {
    int mod=(int)(1e9)+7;
    int a=0,e=1,i=2,o=3,u=4;
    long[][] dp;

    public int countVowelPermutation(int n) {
        long result=0;
        dp=new long[5][n];

        for (int i=0;i<5;i++)
            dp[i][0]=1;

        for (int pos=1;pos<n;pos++)
        {
            dp[a][pos]=dp[e][pos-1]%mod;
            dp[e][pos]=(dp[a][pos-1]+dp[i][pos-1])%mod;
            dp[i][pos]=(dp[a][pos-1]+dp[e][pos-1]+dp[o][pos-1]+dp[u][pos-1])%mod;
            dp[o][pos]=(dp[i][pos-1]+dp[u][pos-1])%mod;
            dp[u][pos]=dp[a][pos-1]%mod;
        }

        for (int i=0;i<5;i++)
            result=(result+dp[i][n-1])%mod;

        return (int)result;
    }
}