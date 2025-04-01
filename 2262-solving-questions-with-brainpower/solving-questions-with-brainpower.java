class Solution {
    public long mostPoints(int[][] questions) {
        int n=questions.length;
        long[] dp=new long[n];

        Arrays.fill(dp,-1);

        return helper(0,dp,questions,n);
    }

    public long helper(int pos,long[] dp,int[][] questions,int n) {
        if (pos>=n) {
            return 0;
        }

        if (dp[pos]!=-1)
            return dp[pos];

        long maxPoints=0;
        long solve=(long)questions[pos][0]+helper(pos+questions[pos][1]+1,dp,questions,n);
        long skip=helper(pos+1,dp,questions,n);

        maxPoints=Math.max(maxPoints,Math.max(solve,skip));
        return dp[pos]=maxPoints;
    }
}