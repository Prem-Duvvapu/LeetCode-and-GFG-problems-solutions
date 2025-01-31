class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int[][] dp=new int[n][3001];
        for (int i=0;i<n;i++)
            for (int j=0;j<3001;j++)
                dp[i][j]=-1;

        Arrays.sort(nums); // Sort in ascending order
        
        // Reverse the sorted numsay
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }

        return solve(n-1,nums,target,dp);
    }

    private int solve(int pos,int[] nums,int target,int[][] dp) {
        if (pos<0) {
            if (target==0)
                return 1;
            return 0;
        }

        if (dp[pos][target+1000]!=-1)
            return dp[pos][target+1000];

        int add=nums[pos]+solve(pos-1,nums,target-nums[pos],dp);
        int sub=-1*nums[pos]+solve(pos-1,nums,target+nums[pos],dp);

        int res=add+sub;

        return dp[pos][target+1000]=res;
    }
}