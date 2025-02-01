class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n][n];

        for (int i=0;i<n;i++)
            for (int j=0;j<n;j++)
                dp[i][j]=-1;

        return solve(0,-1,nums,dp);
    }

    private int solve(int pos,int prev,int[] nums,int[][] dp) {
        if (pos==nums.length)
            return 0;

        if (dp[pos][prev+1]!=-1)
            return dp[pos][prev+1];

        int notPick=solve(pos+1,prev,nums,dp);
        int pick=0;
        if (prev==-1 || nums[pos]>nums[prev])
            pick=1+solve(pos+1,pos,nums,dp);

        return dp[pos][prev+1]=Math.max(pick,notPick);
    }
}