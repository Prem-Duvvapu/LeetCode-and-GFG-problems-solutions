//tabulation
class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        int[] dp=new int[n+1];
        dp[n]=1;
        
        for (int pos=n-1;pos>=0;pos--) {
            if (s.charAt(pos)=='0')
                dp[pos]=0;
            else
                dp[pos]=dp[pos+1];

            if (pos+1<n && (s.charAt(pos)=='1' || s.charAt(pos)=='2' && s.charAt(pos+1)<'7'))
                dp[pos]+=dp[pos+2];
        }

        return dp[0];
    }
}