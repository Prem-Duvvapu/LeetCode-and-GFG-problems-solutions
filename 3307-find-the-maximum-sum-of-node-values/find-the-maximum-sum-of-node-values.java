class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long res=0;
        int cnt=0;

        for (int val: nums) {
            if ((val^k)>val)
                cnt++;

            res+=Math.max(val,val^k);
        }

        if ((cnt&1)==0)//even
            return res;

        int minLoss=Integer.MAX_VALUE;
        int minProfit=Integer.MAX_VALUE;

        for (int val: nums) {
            if ((val^k)>val)
                minProfit=Math.min(minProfit,(val^k)-val);
            else if (val>(val^k))
                minLoss=Math.min(minLoss,val-(val^k));
        }
        
        res=Math.max(res-minLoss,res-minProfit);
        return res;
    }
}