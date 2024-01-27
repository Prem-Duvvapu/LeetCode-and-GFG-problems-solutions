class Solution {
    int mod=(int)1e9+7;

    public int kInversePairs(int n, int k) {
        int[][] memo=new int[n+1][k+1];

        for (int[] arr: memo)
            Arrays.fill(arr,-1);

        return solve(n,k,memo);
    }

    private int solve(int n,int k,int[][] memo) {
        if (n==0)
            return 0;

        if (k==0)
            return 1;

        if (memo[n][k]!=-1)
            return memo[n][k];

        int res=0;
        for (int i=0;i<=Math.min(n-1,k);i++) {
            res=(res+solve(n-1,k-i,memo))%mod;
        }

        return memo[n][k]=res;
    }
}