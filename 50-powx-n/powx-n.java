class Solution {
    public double myPow(double x, int n) {
        if (x==1.0 || n==0)
            return 1.0;

        if (n<0) {
            n=Math.abs(n);
            x=1/x;
        }

        double res=1.0;
        while (n!=00) {
            if ((n&1)==1)
                res*=x;

            n/=2;
            x*=x;
        }

        return res;
    }
}