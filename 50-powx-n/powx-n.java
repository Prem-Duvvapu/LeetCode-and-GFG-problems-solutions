class Solution {
    public double myPow(double x, int n) {
        if (x==1.0 || n==0)
            return 1;

        if (n<0)
        {
            n=-n;
            x=1/x;
        }

        double res=1.0;
        while (n!=0)
        {
            if (n%2==1)
                res=res*x;

            x=x*x;
            n=n>>>1;
        }

        return res;
    }
}