//Space optimization
class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        int dp=0,dp1=1,dp2=0;
        
        for (int pos=n-1;pos>=0;pos--) {
            if (s.charAt(pos)=='0')
                dp=0;
            else
                dp=dp1;

            if (pos+1<n && (s.charAt(pos)=='1' || s.charAt(pos)=='2' && s.charAt(pos+1)<'7'))
                dp+=dp2;

            dp2=dp1;
            dp1=dp;
        }

        return dp;
    }
}