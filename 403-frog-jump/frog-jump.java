class Solution {
    public boolean canCross(int[] stones) {
        int n=stones.length;
        if (n>1 && stones[1]>1)
            return false;

        int[][] dp=new int[2000][1000];
        for (int[] arr: dp)
            Arrays.fill(arr,-1);
        return solve(1,1,stones,n,dp);
    }

    private boolean solve(int pos,int last,int[] stones,int n,int[][] dp)
    {
        if (pos==n-1)
            return true;

        if (dp[pos][last]!=-1)
            return (dp[pos][last]==1);

        for (int i=pos+1;i<n;i++)
        {
            if (stones[i]==stones[pos]+last-1 && solve(i,last-1,stones,n,dp))
            {
                dp[pos][last]=1;
                return true;
            }

            if (stones[i]==stones[pos]+last && solve(i,last,stones,n,dp))
            {
                dp[pos][last]=1;
                return true;
            }

            if (stones[i]==stones[pos]+last+1 && solve(i,last+1,stones,n,dp))
            {
                dp[pos][last]=1;
                return true;
            }
        }

        dp[pos][last]=0;
        return false;
    }
}