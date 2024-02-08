class Solution {
    public int numSquares(int n) {
        int[][] dp=new int[101][n+1];
        for (int[] arr: dp)
            Arrays.fill(arr,-1);
        return solve(1,n,dp);
    }

    private int solve(int num,int target,int[][] dp) {
        if (target==0)
            return 0;

        if (num*num>target)
            return 100000;

        if (dp[num][target]!=-1)
            return dp[num][target];

        int notPick=0+solve(num+1,target,dp);
        int pick=1+solve(num,target-num*num,dp);

        return dp[num][target]=Math.min(pick,notPick);
    }
}