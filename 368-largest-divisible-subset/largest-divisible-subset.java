class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        List<Integer> res=new ArrayList<>();
        int[] dp=new int[n];
        int[] prevIndex=new int[n];
        int finalIndex=0;

        Arrays.sort(nums);
        Arrays.fill(dp,1);

        for (int i=0;i<n;i++)
            prevIndex[i]=i;

        for (int i=0;i<n;i++) {
            for (int prev=0;prev<i;prev++) {
                if (nums[i]%nums[prev]==0 && dp[prev]+1>dp[i]) {
                    dp[i]=1+dp[prev];
                    prevIndex[i]=prev;
                }
            }

            if (dp[i]>dp[finalIndex])
                finalIndex=i;
        }

        int index=finalIndex;
        while (prevIndex[index]!=index) {
            res.add(nums[index]);
            index=prevIndex[index];
        }
        res.add(nums[index]);

        return res;
    }
}