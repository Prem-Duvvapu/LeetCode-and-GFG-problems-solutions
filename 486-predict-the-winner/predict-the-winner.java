class Solution {
    private int solve(int[] nums,int left,int right)
    {
        if (left>right)
            return 0;

        if (left==right)
            return nums[left];

        int take_left=nums[left]+Math.min(solve(nums,left+2,right),solve(nums,left+1,right-1));
        int take_right=nums[right]+Math.min(solve(nums,left,right-2),solve(nums,left+1,right-1));

        return Math.max(take_left,take_right);
    }

    public boolean PredictTheWinner(int[] nums) {
        int n=nums.length;
        int totalScore=0;
        for (int val: nums)
            totalScore+=val;
        int p1=solve(nums,0,n-1);
        int p2=totalScore-p1;
        return (p1>=p2);
    }
}