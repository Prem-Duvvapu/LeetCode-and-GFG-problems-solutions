class Solution {
    public int minArraySum(int[] nums, int k, int op1, int op2) {
        int n=nums.length;
        int[][][] dp = new int[n+1][n+1][n+1];

        for (int i=0;i<=n;i++)
            for (int j=0;j<=n;j++)
                for (int l=0;l<=n;l++)
                    dp[i][j][l]=-1;

        return solve(0,nums,k,op1,op2,dp);
    }
    
    //memoization
    private int solve(int pos,int[] nums,int k,int op1,int op2,int[][][] dp) {
        if (dp[pos][op1][op2]!=-1)
            return dp[pos][op1][op2];

        if (pos == nums.length)
            return 0;

         int minSum = Integer.MAX_VALUE;

        //op1
        if (op1>0) {
            int sumAfterOp1 = (int)Math.ceil(nums[pos]/2.0)+solve(pos+1,nums,k,op1-1,op2,dp);
            minSum = Math.min(minSum,sumAfterOp1);
        }

        //op2
        if (op2>0 && nums[pos]>=k) {
            int sumAfterOp2 = (nums[pos]-k)+solve(pos+1,nums,k,op1,op2-1,dp);
            minSum = Math.min(minSum,sumAfterOp2);
        }

        //op1 then op2
        if (op1>0 && op2>0) {
            int valueAfterOp1 =(int)Math.ceil(nums[pos]/2.0);

            if (valueAfterOp1>=k) {
                int sumAfterOp1AndOp2 = (valueAfterOp1-k)+solve(pos+1,nums,k,op1-1,op2-1,dp);
                minSum = Math.min(minSum,sumAfterOp1AndOp2);
            }
        }

        //op2 then op1
        if (op1>0 && op2>0 && nums[pos]>=k) {
            int valueAfterOp2 = nums[pos]-k;

            int sumAfterOp2AndOp1 = (int)Math.ceil(valueAfterOp2/2.0)+solve(pos+1,nums,k,op1-1,op2-1,dp);
            minSum = Math.min(minSum,sumAfterOp2AndOp1);
        }

        //no op1 and op2
        int sum = nums[pos] + solve(pos+1,nums,k,op1,op2,dp);
        minSum = dp[pos][op1][op2] = Math.min(minSum,sum);

        return minSum;
    }
}