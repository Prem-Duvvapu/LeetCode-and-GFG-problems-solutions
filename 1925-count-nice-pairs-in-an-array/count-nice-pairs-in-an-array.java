//nums[i]+rev(nums[j])==nums[j]+rev(nums[i]) => nums[i]-rev(nums[i])==nums[j]-rev(nums[j])
class Solution {
    public int countNicePairs(int[] nums) {
        int n=nums.length;
        int res=0;
        int mod=(int)1e9+7;
        Map<Integer,Integer> map=new HashMap<>();

        for (int i=0;i<n;i++)
        {
            int key=nums[i]-rev(nums[i]);
            int value=map.getOrDefault(key,0);
            map.put(key,value+1);
            res=(res+value)%mod;
        }

        return res;
    }

    private int rev(int n)
    {
        int rev=0;
        while (n>0)
        {
            int rem=n%10;
            rev=rev*10+rem;
            n/=10;
        }
        return rev;
    }
}