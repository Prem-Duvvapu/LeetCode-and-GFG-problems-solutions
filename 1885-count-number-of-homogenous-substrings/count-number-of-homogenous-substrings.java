class Solution {
    public int countHomogenous(String s) {
        int mod=(int)1e9+7;
        int n=s.length();
        int res=0;
        int left=0;
        int right=0;

        while (right<n)
        {
            if (s.charAt(left)==s.charAt(right))
            {
                res=(res+right-left+1)%mod;
                right++;
            }
            else
                left=right;
        }

        return res;
    }
}