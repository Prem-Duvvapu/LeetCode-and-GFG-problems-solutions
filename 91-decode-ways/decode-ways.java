class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        if (s.charAt(0)=='0')
            return 0;
        return solve(0,s,n,dp);
    }

    private int solve(int pos,String s,int n,int[] dp) {
        if (pos>=n-1) {
            if (pos==n-1 && s.charAt(pos)=='0') 
                return 0;
            return 1;
        }

        if (s.charAt(pos)=='0')
            return 0;

        if (dp[pos]!=-1)
            return dp[pos];

        char curr=s.charAt(pos);
        char next=s.charAt(pos+1);

        if (curr-'0'>=3 || (curr-'0'==2 && next-'0'>6))
            return dp[pos]=solve(pos+1,s,n,dp);

        if (next=='0')
            return dp[pos]=solve(pos+2,s,n,dp);

        int l=solve(pos+1,s,n,dp);
        int r=solve(pos+2,s,n,dp);
        return dp[pos]=l+r;        
    }
}