class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        int[] prefix=new int[n];
        Map<Integer,Integer> map=new HashMap<>();
        int res=0;

        prefix[0]=nums[0];
        for (int i=1;i<n;i++)
            prefix[i]=prefix[i-1]+nums[i];

        for (int i=0;i<n;i++)
        {
            if (prefix[i]==k)
                res++;

            if (map.containsKey(prefix[i]-k))
                res+=map.get(prefix[i]-k);

            map.put(prefix[i],map.getOrDefault(prefix[i],0)+1);
        }

        return res;
    }
}