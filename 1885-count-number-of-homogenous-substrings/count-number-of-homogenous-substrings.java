class Solution {
    public int countHomogenous(String s) {
        int mod=(int)1e9+7;
        int n=s.length();
        int res=0;
        int left=0;

        for (int right=0;right<n;right++)
        {
            if (s.charAt(left)==s.charAt(right))
            {
                res=(res+right-left+1)%mod;
            }
            else
            {
                left=right;
                res=(res+1)%mod;
            }
        }

        return res;
    }
}