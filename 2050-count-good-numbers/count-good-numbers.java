class Solution {
    long mod=(long)1e9+7;

    public int countGoodNumbers(long n) {
        if (n==1)
            return 5;

        long evenPosCnt=(n+1)/2;
        long oddPosCnt=n/2;

        long total=power((long)5,evenPosCnt)%mod*power((long)4,oddPosCnt)%mod;
        total%=mod;

        return (int)total;
    }

    public long power(long base,long expo) {
        if (expo==0)
            return 1;

        long half=power(base,expo/2)%mod;
        long res=(half*half)%mod;;

        if (expo%2==1)
            res*=base;

        return res%mod;
    }
}