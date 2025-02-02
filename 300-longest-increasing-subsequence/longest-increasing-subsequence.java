class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n+1][n+1];

        for (int ind=n-1;ind>=0;ind--) {
            for (int prev=ind-1;prev>=-1;prev--) {
                int notPick=0+dp[ind+1][prev+1];
                int pick=0;
                if (prev==-1 || nums[ind]>nums[prev])
                    pick=1+dp[ind+1][ind+1];

                dp[ind][prev+1]=Math.max(pick,notPick);
            }
        }

        return dp[0][0];
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