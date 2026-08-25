class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];

        for (int[] arr: dp) {
            Arrays.fill(arr,-1);
        }

        return solve(0,-1,nums,dp);
    }

    private int solve(int currIndex,int prevIndex,int[] nums,int[][] dp) {
        if (currIndex >= nums.length) {
            return 0;
        }

        if (dp[currIndex][prevIndex+1] != -1) {
            return dp[currIndex][prevIndex+1];
        }

        int pick = 0;
        if (prevIndex == -1 || nums[currIndex] > nums[prevIndex]) {
            pick = 1 + solve(currIndex+1,currIndex,nums,dp);
        }

        int notPick = 0 + solve(currIndex+1,prevIndex,nums,dp);

        return dp[currIndex][prevIndex+1] = Math.max(pick,notPick);
    }
}