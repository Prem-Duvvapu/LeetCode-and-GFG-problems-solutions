class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return solve(0,s,n,dp);
    }

    private int solve(int pos,String s,int n,int[] dp) {
        if (pos==n)
            return 1;

        if (s.charAt(pos)=='0')
            return 0;

        if (dp[pos]!=-1)
            return dp[pos];

        int res=solve(pos+1,s,n,dp);
        if (pos+1<n && (s.charAt(pos)=='1' || s.charAt(pos)=='2' && s.charAt(pos+1)<'7'))
            res+=solve(pos+2,s,n,dp);

        return dp[pos]=res;
    }
}