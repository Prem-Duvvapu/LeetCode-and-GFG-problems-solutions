//Tabulation
class Solution {
    public long minIncrementOperations(int[] nums, int k) {
        int n=nums.length;
        long[] dp=new long[n+1];
        
        for (int i=n-3;i>=0;i--)
        {
            long a=Math.max(0,k-nums[i])+dp[i+1];
            long b=Math.max(0,k-nums[i+1])+dp[i+2];
            long c=Math.max(0,k-nums[i+2])+dp[i+3];

            dp[i]=Math.min(a,Math.min(b,c));
        }
        
        return dp[0];
    }
}