class NumArray {
    int[] dp;

    public NumArray(int[] nums) {
        int n=nums.length;
        dp=new int[n+1];

        for (int i=1;i<=n;i++)
            dp[i]=nums[i-1]+dp[i-1];
    }
    
    public int sumRange(int left, int right) {
        int sum=dp[right+1]-dp[left];
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */