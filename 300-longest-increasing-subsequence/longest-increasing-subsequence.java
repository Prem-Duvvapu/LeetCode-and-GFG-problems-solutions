class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int res=1;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        List<Integer> l=new ArrayList<>();

        for (int i=1;i<n;i++)
        {
            List<Integer> temp=new ArrayList<>();
            for (int j=0;j<i;j++)
            {
                if (nums[j]<nums[i] && dp[i]==dp[j])
                {
                    temp.add(nums[j]);
                    dp[i]=1+dp[j];
                }
            }
            temp.add(nums[i]);
            if (temp.size()>l.size())
                l=temp;
            res=Math.max(res,dp[i]);
        }

        System.out.println(l);
        return res;
    }
}