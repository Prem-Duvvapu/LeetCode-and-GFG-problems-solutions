class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n=nums.size();
        int[] cnt=new int[n];
        int sum=0;

        for (int i=0;i<n;i++) {
            if (nums.get(i)%modulo==k)
                sum++;
            cnt[i]=sum;
        }
        
        return subarrays(cnt,modulo,k);
    }

    public long subarrays(int[] nums,int modulo,int k) {
        int n=nums.length;
        long res=0L;
        long currSum=0L;
        Map<Integer,Long> map=new HashMap<>();
        map.put(0,1L);

        for (int i=0;i<n;i++) {
            currSum=nums[i];
            int r1=(int)(currSum%modulo);
            int r2=(r1-k+modulo)%modulo;

            res+=map.getOrDefault(r2,0L);
            map.put(r1,map.getOrDefault(r1,0L)+1);
        }

        return res;
    }
}