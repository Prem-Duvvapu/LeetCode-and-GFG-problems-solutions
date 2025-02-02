class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        int res=1;
        Arrays.fill(dp,1);

        for (int i=0;i<n;i++) {
            for (int prev=0;prev<i;prev++) {
                if (nums[i]>nums[prev] && dp[prev]+1>dp[i]) {
                    dp[i]=1+dp[prev];
                }
                res=Math.max(res,dp[i]);
            }
        }

        return res;
    }
}