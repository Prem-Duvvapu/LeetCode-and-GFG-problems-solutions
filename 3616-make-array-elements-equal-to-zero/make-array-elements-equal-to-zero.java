class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        int res = 0;

        for (int i=1;i<n;i++)
            leftSum[i] = leftSum[i-1] + nums[i-1];

        for (int i=n-2;i>=0;i--)
            rightSum[i] = rightSum[i+1] + nums[i+1];

        for (int i=0;i<n;i++) {
            if (nums[i]==0) {
                if (leftSum[i]==rightSum[i])
                    res+=2;
                else if (Math.abs(leftSum[i] - rightSum[i])==1)
                    res++;
            }
        }

        return res;
    }
}