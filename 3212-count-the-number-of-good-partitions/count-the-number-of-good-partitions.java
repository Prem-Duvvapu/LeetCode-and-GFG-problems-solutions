class Solution {
    public int numberOfGoodPartitions(int[] nums) {
        int n=nums.length;
        int res=1;
        int mod=(int)1e9+7;
        int maxRight=0;
        Map<Integer,Integer> map=new HashMap<>();

        for (int i=0;i<n;i++)
            map.put(nums[i],i);

        for (int i=0;i<n;i++)
        {
            if (i>maxRight)
                res=(res*2)%mod;

            maxRight=Math.max(maxRight,map.get(nums[i]));
        }

        return res;
    }
}