class Solution {
    public double myPow(double x, int n) {
        if (x == 1.0 || n == 0)
            return 1.0;

        if (n < 0) {
            x = 1/x;
            n = Math.abs(n);
        }

        double res = 1.0;
        while (n != 0) {
            if ((n&1) == 1)
                res *= x;

            n /= 2;
            x *= x;
        }

        return res;
    }
}