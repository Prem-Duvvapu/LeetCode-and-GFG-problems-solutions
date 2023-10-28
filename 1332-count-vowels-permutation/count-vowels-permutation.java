//Memoization
class Solution {
    int mod=(int)(1e9)+7;
    int a=0,e=1,i=2,o=3,u=4;
    int[][] dp;

    public int countVowelPermutation(int n) {
        int result=0;
        dp=new int[5][n];

        for (int[] arr: dp)
            Arrays.fill(arr,-1);

        result=(result+solve(a,n-1))%mod;
        result=(result+solve(e,n-1))%mod;
        result=(result+solve(i,n-1))%mod;
        result=(result+solve(o,n-1))%mod;
        result=(result+solve(u,n-1))%mod;

        return result;
    }

    private int solve(int prev,int pos)
    {
        if (pos==0)
            return 1;

        if (dp[prev][pos]!=-1)
            return dp[prev][pos];

        if (prev==a)
            return dp[prev][pos]=solve(e,pos-1)%mod;
        else if (prev==e)
            return dp[prev][pos]=(solve(a,pos-1)%mod+solve(i,pos-1)%mod)%mod;
        else if (prev==i)
            return dp[prev][pos]=((solve(a,pos-1)%mod+solve(e,pos-1)%mod)%mod+(solve(o,pos-1)%mod+solve(u,pos-1)%mod)%mod)%mod;
        else if (prev==o)
            return dp[prev][pos]=(solve(i,pos-1)%mod+solve(u,pos-1)%mod)%mod;
        
        return dp[prev][pos]=solve(a,pos-1)%mod;
    }
}