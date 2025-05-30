class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n=nums.length;
        int res=0;
        int prevRem=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);

        for (int i=0;i<n;i++) {
            int currRem=(prevRem+nums[i])%k;
            if (currRem<0)
                currRem+=k;

            res+=map.getOrDefault(currRem,0);
            map.put(currRem,map.getOrDefault(currRem,0)+1);
            prevRem=currRem;
        }

        return res;
    }
}