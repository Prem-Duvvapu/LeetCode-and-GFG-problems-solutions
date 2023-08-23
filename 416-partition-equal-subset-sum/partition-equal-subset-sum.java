//DP on subsequences
//Memoization

class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for (int val: nums)
            sum+=val;

        if (sum%2==1)//odd
            return false;

        int target=sum/2;
        int[][] dp=new int[n][target+1];

        for (int[] arr: dp)
            Arrays.fill(arr,-1);

        return solve(n-1,target,nums,dp);
    }

    private boolean solve(int index,int target,int[] nums,int[][] dp)
    {
        if (target==0)
            return true;

        if (index==0)
            return nums[0]==target;

        if (dp[index][target]!=-1)
            return (dp[index][target]==1);

        boolean notTake=solve(index-1,target,nums,dp);
        boolean take=false;
        if (nums[index]<=target)
            take=solve(index-1,target-nums[index],nums,dp);

        if (take || notTake)
            dp[index][target]=1;
        else
            dp[index][target]=0;

        return (take || notTake);
    }
}