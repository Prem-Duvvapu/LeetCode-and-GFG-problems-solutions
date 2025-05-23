class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long res=0;
        int cnt=0;
        int minLoss=Integer.MAX_VALUE;

        for (int val: nums) {
            if ((val^k)>val) {
                cnt++;
                res+=(val^k);
            } else {
                res+=val;
            }

            minLoss=Math.min(minLoss,Math.abs(val-(val^k)));
        }

        if ((cnt&1)==0)//even
            return res;

        res-=minLoss;
        return res;
    }
}