class Solution {
    public int maximumXorProduct(long a, long b, int n) {
        long mod=(long)1e9+7;

        for (int i=n-1;i>=0;i--)
        {
            long val=1L<<i;
            if ((a&val)==(b&val)) //same bits
            {
                a=(a|val);
                b=(b|val);
            }
            else //different bits
            {
                if (a<b)
                {
                    a=(a|val);
                    b=(b&(~val));
                }
                else
                {
                    b=(b|val);
                    a=(a&(~val));
                }
            }
        }

        a%=mod;
        b%=mod;
        return (int)((a*b)%mod);
    }
}