class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int prev1=nums[n-1];
        int prev2=0;

        for (int i=n-2;i>=0;i--) {
            int pick=nums[i]+prev2;
            int notPick=prev1;

            int curr=Math.max(pick,notPick);
            prev2=prev1;
            prev1=curr;
        }

        return prev1;
    }
}