class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n=jobDifficulty.length;

        if (n<d)
            return -1;

        int[][] dp=new int[n][d+1];
        for (int i=0;i<n;i++)
            for (int j=0;j<=d;j++)
                dp[i][j]=-1;

        return solve(0,jobDifficulty,d,dp);
    }

    private int solve(int pos,int[] a,int d,int[][] dp) {
        if (a.length-pos<d)
            return 1000000;

        if (d==1) {
            int maxVal=a[pos];
            for (int k=pos;k<a.length;k++)
                maxVal=Math.max(maxVal,a[k]);
            return maxVal;
        }

        if (dp[pos][d]!=-1)
            return dp[pos][d];

        int res=Integer.MAX_VALUE;
        int maxVal=a[pos];

        for (int k=pos;k<a.length;k++) {
            maxVal=Math.max(maxVal,a[k]);
            int curr=maxVal+solve(k+1,a,d-1,dp);
            res=Math.min(res,curr);
        }

        return dp[pos][d]=res;
    }
}