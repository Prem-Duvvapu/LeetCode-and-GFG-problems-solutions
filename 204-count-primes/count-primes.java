class Solution {
    public int countPrimes(int n) {
        int cnt=0;
        boolean[] isPrime=new boolean[n];
        Arrays.fill(isPrime,true);

        for (int i=2;(long)i*i<=(long)n;i++) {
            if (!isPrime[i])
                continue;

            for (long j=(long)i*i;j<(long)n;j+=i)
                isPrime[(int)j]=false;
        }

        for (int i=2;i<n;i++)
            if (isPrime[i])
                cnt++;

        return cnt;
    }
}