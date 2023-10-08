//Bit Manipulation(Counting sort)
class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int n=nums.size();
        int mod=(int)(1e9)+7;
        int[] cnt=new int[32];
        long ans=0;

        for (int val: nums)
            for (int i=0;i<32;i++)
                if ((val&(1<<i)) != 0)
                    cnt[i]++;
            
        for (int j=0;j<k;j++)
        {
            long curr=0;
            for (int i=0;i<32;i++)
            {
                if (cnt[i]>0)
                {
                    curr|=(1<<i);
                    cnt[i]--;
                }
            }

            ans=(ans+(curr*curr)%mod)%mod;
        }

        return (int)ans;
    }
}