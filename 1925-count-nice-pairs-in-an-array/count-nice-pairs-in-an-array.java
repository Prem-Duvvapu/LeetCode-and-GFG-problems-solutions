//nums[i]+rev(nums[j])==nums[j]+rev(nums[i]) => nums[i]-rev(nums[i])==nums[j]-rev(nums[j])
class Solution {
    public int countNicePairs(int[] nums) {
        int n=nums.length;
        long res=0;
        long mod=(int)1e9+7;
        Map<Integer,Integer> map=new HashMap<>();

        for (int i=0;i<n;i++)
        {
            int key=nums[i]-rev(nums[i]);
            map.put(key,map.getOrDefault(key,0)+1);
        }

        System.out.println(map);
        for (Integer val: map.values())
        {
            long temp=0;
            if (val%2==0)
            {
                temp=val/2;
                temp=(temp*(val-1))%mod;
            }
            else
            {
                temp=(val-1)/2;
                temp=(temp*val);
            }
            res=(res+temp)%mod;
        }

        return (int)res;
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