//memoization
class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        //pos is changing [0,n-1]
        int[] dp=new int[n];
        Arrays.fill(dp,-1);

        return solve(0,dp,nums,n);
    }

    public int solve(int pos,int[] dp,int[] nums,int n) {
        if (pos==n-1)
            return nums[pos];

        if (pos>=n)
            return 0;

        if (dp[pos]!=-1)
            return dp[pos];

        int pick=nums[pos]+solve(pos+2,dp,nums,n);
        int notPick=0+solve(pos+1,dp,nums,n);

        return dp[pos]=Math.max(pick,notPick);
    }
}

/*
Dynamic programming(DP) - storing states/(remembering the past)
1. write a recursive solution
2. write memoization
3. write tabulation
4. write space optimization

Sub-topics
1. Simple DP / 1-D Dp -> 1
2. Dp on grids -> 1
3. Dp on subsequences -> 2
4. Dp on strings -> 1
5. Dp on stocks -> 1
6. Dp on Longest Increasing subsequence
7. Partion Dp(hard)
*/




